package com.wyh2020.fstore.service;

import com.wyh2020.fstore.base.service.BaseService;
import com.wyh2020.fstore.condition.trade.TradeCondition;
import com.wyh2020.fstore.po.trade.TradePo;

public interface TradeService extends BaseService<TradePo, TradeCondition> {



    /**
     * 获取新的TradeNo
     * @return
     */
    String queryTradeNo();

}