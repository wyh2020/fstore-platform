package com.wyh2020.fstore.dao;


import com.wyh2020.fstore.base.mapper.BaseMapper;
import com.wyh2020.fstore.condition.user.UserCondition;
import com.wyh2020.fstore.po.user.UserPo;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserPo, UserCondition> {

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