package com.wyh2020.fstore.service.impl;

import com.wyh2020.fstore.base.service.BaseServiceImpl;
import com.wyh2020.fstore.condition.user.UserCondition;
import com.wyh2020.fstore.dao.UserMapper;
import com.wyh2020.fstore.po.user.UserPo;
import com.wyh2020.fstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wyh
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserPo, UserCondition, UserMapper> implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public UserPo queryUserByPhone(String phone) {
        return userMapper.queryUserByPhone(phone);
    }

    @Override
    public String queryUserCode(String prefix) {
        return userMapper.queryUserCode(prefix);
    }
}