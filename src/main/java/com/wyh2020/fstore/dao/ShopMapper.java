package com.wyh2020.fstore.dao;

import com.wyh2020.fstore.base.mapper.BaseMapper;
import com.wyh2020.fstore.condition.shop.ShopCondition;
import com.wyh2020.fstore.po.shop.ShopPo;

public interface ShopMapper extends BaseMapper<ShopPo, ShopCondition> {

    /**
     * 通过userCode查找店铺信息
     * @param userCode
     * @return
     */
    public ShopPo queryByUserCode(String userCode);


    /**
     * 获取新的ShopCode
     * @return
     */
    String queryShopCode();
}