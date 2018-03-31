package com.wyh2020.fstore.service.impl;

import com.wyh2020.fstore.base.service.BaseServiceImpl;
import com.wyh2020.fstore.condition.shop.ShopCondition;
import com.wyh2020.fstore.dao.ShopMapper;
import com.wyh2020.fstore.po.shop.ShopPo;
import com.wyh2020.fstore.service.ShopService;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl extends BaseServiceImpl<ShopPo, ShopCondition, ShopMapper> implements ShopService {

}