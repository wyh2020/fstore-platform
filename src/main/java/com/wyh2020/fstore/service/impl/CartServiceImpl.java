package com.wyh2020.fstore.service.impl;

import com.wyh2020.fstore.base.service.BaseServiceImpl;
import com.wyh2020.fstore.condition.cart.CartCondition;
import com.wyh2020.fstore.dao.CartMapper;
import com.wyh2020.fstore.po.cart.CartPo;
import com.wyh2020.fstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl extends BaseServiceImpl<CartPo, CartCondition, CartMapper> implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public void deleteList(String[] list) {
        cartMapper.deleteList(list);
    }
}