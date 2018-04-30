package com.wyh2020.fstore.service.impl;


import com.wyh2020.fstore.base.service.BaseServiceImpl;
import com.wyh2020.fstore.condition.classs.ClassCondition;
import com.wyh2020.fstore.dao.ClassMapper;
import com.wyh2020.fstore.po.classs.ClassPo;
import com.wyh2020.fstore.service.ClassService;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl extends BaseServiceImpl<ClassPo, ClassCondition, ClassMapper> implements ClassService {

}