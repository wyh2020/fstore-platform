package com.wyh2020.fstore.dao;

import com.wyh2020.fstore.pojo.Test;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with wyh.
 * Date: 2017/7/2
 * Time: 上午12:50
 */
@Repository
public interface TestMapper {

    List<Test> getTestList();
}
