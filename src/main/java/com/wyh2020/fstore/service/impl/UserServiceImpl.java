package com.wyh2020.fstore.service.impl;

import com.wyh2020.fstore.base.service.BaseServiceImpl;
import com.wyh2020.fstore.condition.user.UserCondition;
import com.wyh2020.fstore.dao.UserMapper;
import com.wyh2020.fstore.po.user.UserPo;
import com.wyh2020.fstore.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author wyh
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserPo, UserCondition, UserMapper> implements UserService {

}