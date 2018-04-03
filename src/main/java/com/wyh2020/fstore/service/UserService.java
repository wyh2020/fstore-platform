package com.wyh2020.fstore.service;

import com.wyh2020.fstore.base.service.BaseService;
import com.wyh2020.fstore.condition.user.UserCondition;
import com.wyh2020.fstore.po.user.UserPo;

public interface UserService extends BaseService<UserPo, UserCondition> {

    /**
     * 根据号码查用户信息
     * @param phone
     * @return
     */
    UserPo queryUserByPhone(String phone);


    /**
     * 获取新的UserCode
     * @param prefix
     * @return
     */
    String queryUserCode(String prefix);

}