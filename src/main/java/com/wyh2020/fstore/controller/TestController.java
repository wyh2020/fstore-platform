package com.wyh2020.fstore.controller;

import com.wyh2020.fstore.pojo.Test;
import com.wyh2020.fstore.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with wyh.
 * Date: 2017/7/2
 * Time: 上午12:47
 */
@RestController
@RequestMapping("/test")
@Api(value = "TestController", description = "测试接口")
public class TestController {

    @Autowired
    private TestService testService;


    Logger logger = Logger.getLogger(TestController.class);


    @RequestMapping("/queryList")
    @ApiOperation(value = "查询Test列表", notes = "查询Test列表")
    public String getTestList(){
        logger.info("进入接口啦啦啦啦啦啦");
        List<Test> testList = testService.getTestList();

        return testList.toString();
    }

}
