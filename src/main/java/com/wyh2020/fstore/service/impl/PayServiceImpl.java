package com.wyh2020.fstore.service.impl;


import com.wyh2020.fstore.base.service.BaseServiceImpl;
import com.wyh2020.fstore.condition.pay.PayCondition;
import com.wyh2020.fstore.dao.PayMapper;
import com.wyh2020.fstore.po.pay.PayPo;
import com.wyh2020.fstore.service.PayService;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl extends BaseServiceImpl<PayPo, PayCondition, PayMapper> implements PayService {

}