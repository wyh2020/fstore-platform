package com.wyh2020.fstore.dao;


import com.wyh2020.fstore.base.mapper.BaseMapper;
import com.wyh2020.fstore.condition.user.UserCondition;
import com.wyh2020.fstore.po.user.UserPo;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserPo, UserCondition> {

}