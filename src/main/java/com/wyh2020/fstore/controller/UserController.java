package com.wyh2020.fstore.controller;

import com.wyh2020.fstore.base.annotation.Identity;
import com.wyh2020.fstore.base.bean.role.identity.IdentityUser;
import com.wyh2020.fstore.base.controller.BaseController;
import com.wyh2020.fstore.base.response.CentreCutPageResponse;
import com.wyh2020.fstore.base.response.CentreListResponse;
import com.wyh2020.fstore.base.response.ResponseEntity;
import com.wyh2020.fstore.base.util.CopyUtil;
import com.wyh2020.fstore.base.util.UUIDUtil;
import com.wyh2020.fstore.condition.user.UserCondition;
import com.wyh2020.fstore.entity.JwtUser;
import com.wyh2020.fstore.exception.GateWayException;
import com.wyh2020.fstore.form.user.UserCreateForm;
import com.wyh2020.fstore.form.user.UserQueryForm;
import com.wyh2020.fstore.form.user.UserUpdateForm;
import com.wyh2020.fstore.po.user.UserPo;
import com.wyh2020.fstore.service.UserService;
import com.wyh2020.fstore.vo.user.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author hzh
 */
@RestController
@RequestMapping("/od/user")
@Api(value = "/od/user", description = "用户信息")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "查询",notes = "查询",httpMethod = "GET")
	@RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<UserVo> query(@ApiParam(value = "用户编号", required = true)@RequestParam String usercode) throws GateWayException {
		UserPo po = userService.queryWithValid(usercode);
		UserVo vo = CopyUtil.transfer(po, UserVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "查询数量",notes = "查询数量",httpMethod = "GET")
	@RequestMapping(value = "/queryCount", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<Integer> queryCount(@ModelAttribute@Valid UserQueryForm form) throws GateWayException {
		UserCondition condition = this.getConditionByQueryForm(form);
		int count = userService.queryCount(condition);
		return getSuccessResult(count);
	}

	@ApiOperation(value = "查询列表",notes = "查询列表",httpMethod = "GET")
	@RequestMapping(value = "/queryList", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<CentreListResponse<UserVo>> queryList(@Identity IdentityUser identityUser, @ModelAttribute@Valid UserQueryForm form) throws GateWayException {
		UserCondition condition = this.getConditionByQueryForm(form);
		List<UserPo> poList = userService.queryList(condition);
		List<UserVo> voList = CopyUtil.transfer(poList, UserVo.class);
		return getSuccessResult(getListResponse(voList));
	}

	@ApiOperation(value = "查询列表(带分页)",notes = "查询列表(带分页)",httpMethod = "GET")
	@RequestMapping(value = "/queryPageList", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<CentreCutPageResponse<UserVo>> queryPageList(@ModelAttribute@Valid UserQueryForm form) throws GateWayException {
		UserCondition condition = this.getConditionByQueryForm(form);
		List<UserVo> voList = new ArrayList<>();
		int count = userService.queryCount(condition);
		if (count > 0) {
			List<UserPo> poList = userService.queryList(condition);
			voList = CopyUtil.transfer(poList, UserVo.class);
		}
		return getSuccessResult(getPageResponse(form, count, voList));
	}

	@ApiOperation(value = "新增",notes = "新增",httpMethod = "POST")
	@RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<UserVo> add(@ModelAttribute@Valid UserCreateForm form) throws GateWayException {
		UserPo po = CopyUtil.transfer(form, UserPo.class);
		po.setUsercode(UUIDUtil.getUUID());
		userService.insert(po);
		UserVo vo = CopyUtil.transfer(po, UserVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "修改",notes = "修改",httpMethod = "POST")
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity update(@RequestBody@Valid UserUpdateForm form, BindingResult result, HttpServletRequest request) throws GateWayException {
		UserPo po = CopyUtil.transfer(form, UserPo.class);
		JwtUser jwtUser = this.checkLogin(request);
		String userCode = jwtUser.getUserCode();
		po.setUpdater(userCode);
		po.setUpdatetime(new Date());
		userService.update(po);
		return getSuccessResult(po);
	}

	@ApiOperation(value = "删除",notes = "删除",httpMethod = "POST")
	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity delete(@ApiParam(value = "用户编号", required = true)@RequestParam String usercode) throws GateWayException {
		userService.delete(usercode);
		return getSuccessResult();
	}

	/**
	 * UserQueryForm转换为UserCondition
	 *
	 * @param form
	 * @return
	 */
	private UserCondition getConditionByQueryForm(UserQueryForm form) {
		UserCondition condition = CopyUtil.transfer(form, UserCondition.class);
		return condition;
	}

}