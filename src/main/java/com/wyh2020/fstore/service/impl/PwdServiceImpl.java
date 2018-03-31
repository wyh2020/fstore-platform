package com.wyh2020.fstore.service.impl;


import com.wyh2020.fstore.base.service.BaseServiceImpl;
import com.wyh2020.fstore.condition.pwd.PwdCondition;
import com.wyh2020.fstore.dao.PwdMapper;
import com.wyh2020.fstore.po.pwd.PwdPo;
import com.wyh2020.fstore.service.PwdService;
import org.springframework.stereotype.Service;

@Service
public class PwdServiceImpl extends BaseServiceImpl<PwdPo, PwdCondition, PwdMapper> implements PwdService {

}