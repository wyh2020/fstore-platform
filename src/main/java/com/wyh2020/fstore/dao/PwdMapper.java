package com.wyh2020.fstore.dao;


import com.wyh2020.fstore.base.mapper.BaseMapper;
import com.wyh2020.fstore.condition.pwd.PwdCondition;
import com.wyh2020.fstore.po.pwd.PwdPo;

public interface PwdMapper extends BaseMapper<PwdPo, PwdCondition> {

    /**
     * 通过code、密码 获取密码对象
     * @param condition
     * @return
     */
    public PwdPo queryByCodeAndPwd(PwdCondition condition);

}