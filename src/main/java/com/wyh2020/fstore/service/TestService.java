package com.wyh2020.fstore.service;

import com.wyh2020.fstore.pojo.Test;

import java.util.List;

/**
 * Created with wyh.
 * Date: 2017/7/2
 * Time: 上午12:52
 */
public interface TestService {

    List<Test> getTestList();

    int querySum(int id);

    void updateSum(Test test);
}
