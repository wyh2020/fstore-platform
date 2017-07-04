package com.wyh2020.fstore.service;

import com.wyh2020.fstore.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Created with wyh.
 * Date: 2017/7/4
 * Time: 下午5:47
 */
public interface UserService {
    //添加
    public void insert(User user, String collectionName);

    //根据条件查找
    public User findOne(Map<String, Object> params, String collectionName);

    //查找所有
    public List<User> findAll(Map<String, Object> params, String collectionName);

    //修改
    public void update(Map<String, Object> params, String collectionName);

    //创建集合
    public void createCollection(String collectionName);

    //根据条件删除
    public void remove(Map<String, Object> params, String collectionName);
}
