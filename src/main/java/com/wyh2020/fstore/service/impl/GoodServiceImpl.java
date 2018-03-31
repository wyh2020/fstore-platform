package com.wyh2020.fstore.service.impl;


import com.wyh2020.fstore.base.service.BaseServiceImpl;
import com.wyh2020.fstore.condition.good.GoodCondition;
import com.wyh2020.fstore.dao.GoodMapper;
import com.wyh2020.fstore.po.good.GoodPo;
import com.wyh2020.fstore.service.GoodService;
import org.springframework.stereotype.Service;

@Service
public class GoodServiceImpl extends BaseServiceImpl<GoodPo, GoodCondition, GoodMapper> implements GoodService {

}