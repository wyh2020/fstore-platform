package com.wyh2020.fstore.service.impl;

import com.wyh2020.fstore.base.service.BaseServiceImpl;
import com.wyh2020.fstore.condition.cart.CartCondition;
import com.wyh2020.fstore.dao.CartMapper;
import com.wyh2020.fstore.po.cart.CartPo;
import com.wyh2020.fstore.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl extends BaseServiceImpl<CartPo, CartCondition, CartMapper> implements CartService {

}