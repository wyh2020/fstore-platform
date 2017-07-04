package com.wyh2020.fstore.controller;

import com.wyh2020.fstore.pojo.User;
import com.wyh2020.fstore.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created with wyh.
 * Date: 2017/7/4
 * Time: 下午11:06
 */
@RestController
@RequestMapping("/user")
@Api(value = "UserController", description = "User接口")
public class UserController {



    @Autowired
    private UserService userService;



    private static String collectionName = "User";

    Logger logger = Logger.getLogger(UserController.class);



    @ApiOperation(value = "添加并根据条件查找列表", notes = "添加并根据条件查找列表", httpMethod = "GET")
    @RequestMapping(value = "/queryUserList", method = {RequestMethod.GET, RequestMethod.POST})
    public List<User> getUserList(){
        //添加一百个user
        for(int i=0;i<100;i++){
            User user =new User();
            user.setId(""+i);
            user.setAge(i);
            user.setName("zcy"+i);
            user.setPassword("zcy"+i);
            userService.insert(user,collectionName);
        }
        logger.info("添加100个user成功");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("maxAge", 50);
        List<User> users = userService.findAll(params,collectionName);
        System.out.println("users.size()===" + users.size());
        logger.info("查询列表成功");
        return users;
    }



    @ApiOperation(value = "根据ID进行修改", notes = "根据ID进行修改", httpMethod = "GET")
    @RequestMapping(value = "/updateUser", method = {RequestMethod.GET, RequestMethod.POST})
    public User updateUser(){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("id", "1");
        User user=userService.findOne(params, collectionName);
        System.out.println("user.name==="+user.getName());
        System.out.println("=============update==================");
        params.put("name", "hello");
        userService.update(params, collectionName);
        user=userService.findOne(params, collectionName);
        logger.info("修改成功");
        System.out.println("user.name==="+user.getName());
        return user;
    }


    @ApiOperation(value = "根据ID删除对应的数据", notes = "根据ID删除对应的数据", httpMethod = "GET")
    @RequestMapping(value = "/removeUser", method = {RequestMethod.GET, RequestMethod.POST})
    public User removeUser(){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("id", "2");
        userService.remove(params, collectionName);
        User user=userService.findOne(params, collectionName);
        System.out.println("user=="+user);
        logger.info("删除成功");
        return user;
    }




}
