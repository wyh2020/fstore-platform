package com.wyh2020.fstore.dao;

import com.wyh2020.fstore.base.mapper.BaseMapper;
import com.wyh2020.fstore.condition.cart.CartCondition;
import com.wyh2020.fstore.po.cart.CartPo;

public interface CartMapper extends BaseMapper<CartPo, CartCondition> {

    public void deleteList(String[] list);
}