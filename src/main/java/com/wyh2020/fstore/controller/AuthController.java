package com.wyh2020.fstore.controller;

import com.wyh2020.fstore.base.constants.Constants;
import com.wyh2020.fstore.base.controller.BaseController;
import com.wyh2020.fstore.base.response.ResponseEntity;
import com.wyh2020.fstore.base.util.UUIDUtil;
import com.wyh2020.fstore.condition.pwd.PwdCondition;
import com.wyh2020.fstore.entity.JwtUser;
import com.wyh2020.fstore.exception.GateWayException;
import com.wyh2020.fstore.form.auth.LoginReturnPo;
import com.wyh2020.fstore.form.auth.PCLoginForm;
import com.wyh2020.fstore.form.auth.PCRegForm;
import com.wyh2020.fstore.form.auth.UpdatePswForm;
import com.wyh2020.fstore.form.user.UserQueryForm;
import com.wyh2020.fstore.po.pwd.PwdPo;
import com.wyh2020.fstore.po.user.UserPo;
import com.wyh2020.fstore.service.PwdService;
import com.wyh2020.fstore.service.UserService;
import com.wyh2020.fstore.util.JwtComponent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

/**
 * Created with hzh.
 * Date: 2018/03/31
 * Time: 下午2:23
 */
@RestController
@RequestMapping("/od/auth")
@Api(value = "/od/auth", description = "登陆接口")
public class AuthController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private PwdService pwdService;


    @Autowired
    protected JwtComponent jwtComponent;

    @ApiOperation(value = "PC统一登陆", notes = "PC统一登陆", httpMethod = "GET")
    @RequestMapping(value = "/pcLogin", method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    ResponseEntity<LoginReturnPo> pcLogin(@RequestBody @Valid PCLoginForm loginForm, BindingResult result, HttpServletRequest request) throws GateWayException {

        if (result.hasErrors()) {
            logger.warn("登陆失败,参数不符合要求:" + result.getFieldErrors().get(0).getDefaultMessage());
            return getFailResult(result.getFieldErrors().get(0).getDefaultMessage());
        }


        UserQueryForm userQueryForm = new UserQueryForm();
        userQueryForm.setPhone(loginForm.getPhone());

        UserPo userPo = userService.queryUserByPhone(loginForm.getPhone());

        if(userPo == null){
            return getFailResult("该手机号码没注册用户！");
        }

        PwdCondition pwdCondition = new PwdCondition();
        pwdCondition.setUsercode(userPo.getUsercode());
        //rsa解密
        //pwdCondition.setLoginpwd(RSAUtil.decryptPassword(loginForm.getPassword()));
        //pwdCondition.setLoginpwd(loginForm.getPassword());

        PwdPo pwdPo = pwdService.queryByCodeAndPwd(pwdCondition);

        if(pwdPo == null){
            return getFailResult("登录失败！");
        }

        if(!pwdPo.getLoginpwd().equals(loginForm.getPassword())){
            return getFailResult("密码不正确！");
        }

//        if(!RSAUtil.decryptPassword(pwdPo.getLoginpwd()).equals(RSAUtil.decryptPassword(loginForm.getPassword()))){
//            return getFailResult("密码不正确！");
//        }

        String token = jwtComponent.createToken(userPo.getUsercode(), loginForm.getPhone(), userPo.getType());

        //登陆返回结果
        LoginReturnPo loginReturnPo = new LoginReturnPo();
        loginReturnPo.setToken(token);
        loginReturnPo.setUser(userPo);
        return getSuccessResult(loginReturnPo);
    }


    @ApiOperation(value = "PC统一注册", notes = "PC统一注册", httpMethod = "GET")
    @RequestMapping(value = "/reg", method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    ResponseEntity pcReg(@RequestBody @Valid PCRegForm regForm, BindingResult result, HttpServletRequest request) throws GateWayException {

        if (result.hasErrors()) {
            logger.warn("登陆失败,参数不符合要求:" + result.getFieldErrors().get(0).getDefaultMessage());
            return getFailResult(result.getFieldErrors().get(0).getDefaultMessage());
        }

        if (!regForm.getPassword().equals(regForm.getRePasswd())) {
            return getFailResult("两次输入的密码不一致！");
        }

        UserQueryForm userQueryForm = new UserQueryForm();
        userQueryForm.setPhone(regForm.getPhone());
        UserPo userPo = userService.queryUserByPhone(regForm.getPhone());
        if(userPo != null){
            return getFailResult("该手机号码已注册用户！");
        }

        UserPo userPo1 = new UserPo();
        String prefix;
        if(regForm.getType().equals(Constants.UserType.ADMIN)){
            prefix = "V";
        }else if(regForm.getType().equals(Constants.UserType.SHOP)){
            prefix = "S";
        }else{
            prefix = "C";
        }
        String userCode = userService.queryUserCode(prefix);
        userPo1.setUsercode(userCode);
        userPo1.setPhone(regForm.getPhone());
        userPo1.setName(regForm.getPhone());
        userPo1.setType(regForm.getType());
        userPo1.setState(Constants.UserState.NORMAL);
        userPo1.setCreater(userCode);
        userPo1.setCreatetime(new Date());
        userService.insert(userPo1);

        PwdPo pwdPo = new PwdPo();
        pwdPo.setId(UUIDUtil.getUUID());
        pwdPo.setUsercode(userCode);
//        pwdPo.setLoginpwd(RSAUtil.decryptPassword(regForm.getPassword()));
        pwdPo.setLoginpwd(regForm.getPassword());
        pwdPo.setCreater(userCode);
        pwdPo.setCreatetime(new Date());

        pwdService.insert(pwdPo);

        return getSuccessResult();
    }

    @ApiOperation(value = "退出登录", notes = "退出登录", httpMethod = "POST")
    @RequestMapping(value = "/loginout", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    ResponseEntity loginout(HttpServletRequest request) {
        jwtComponent.evictToken(request);
        return getSuccessResult();
    }


    @ApiOperation(value = "修改密码", notes = "修改密码", httpMethod = "POST")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity updatePassword(@RequestBody @Valid UpdatePswForm form, BindingResult result, HttpServletRequest request) {

        if (!StringUtils.equals(form.getConfirmPassword(), form.getPassword())) {
            return getFailResult("两次输入密码不一致！");
        }

        try {
            JwtUser jwtUser = this.checkLogin(request);
            String userCode = jwtUser.getUserCode();
            //String curPwd = RSAUtil.decryptPassword(form.getOldPwd());
            //String pwd = RSAUtil.decryptPassword(form.getPassword());
            String curPwd = form.getOldPwd();
            String pwd = form.getPassword();


            PwdCondition pwdCondition = new PwdCondition();
            pwdCondition.setUsercode(userCode);
            PwdPo pwdPo = pwdService.queryByCodeAndPwd(pwdCondition);

            if(!pwdPo.getLoginpwd().equals(curPwd)){
                return getFailResult("原始密码错误！");
            }

            pwdPo.setLoginpwd(pwd);
            pwdPo.setUsercode(userCode);

            pwdService.update(pwdPo);

            return getSuccessResult();
        } catch (GateWayException e) {
            logger.warn(e.getMessage(), e);
            return getFailResult(e.getErrCode(), e.getMessage());
        } catch (Exception e) {
            logger.warn(e.getMessage(), e);
            return getFailResult(e.getMessage());
        }
    }

}
