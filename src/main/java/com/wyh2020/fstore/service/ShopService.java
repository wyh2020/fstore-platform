package com.wyh2020.fstore.service;


import com.wyh2020.fstore.base.service.BaseService;
import com.wyh2020.fstore.condition.shop.ShopCondition;
import com.wyh2020.fstore.po.shop.ShopPo;

public interface ShopService extends BaseService<ShopPo, ShopCondition> {

    /**
     * 通过userCode查找店铺信息
     * @param userCode
     * @return
     */
    public ShopPo queryByUserCode(String userCode);

}