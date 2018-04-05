package com.wyh2020.fstore.service.impl;

import com.wyh2020.fstore.base.service.BaseServiceImpl;
import com.wyh2020.fstore.condition.trade.TradeCondition;
import com.wyh2020.fstore.dao.TradeMapper;
import com.wyh2020.fstore.po.trade.TradePo;
import com.wyh2020.fstore.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeServiceImpl extends BaseServiceImpl<TradePo, TradeCondition, TradeMapper> implements TradeService {

    @Autowired
    private TradeMapper tradeMapper;

    @Override
    public String queryTradeNo() {
        return tradeMapper.queryTradeNo();
    }
}