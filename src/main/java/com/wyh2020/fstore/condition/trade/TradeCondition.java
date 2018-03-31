package com.wyh2020.fstore.condition.trade;

import com.wyh2020.fstore.base.condition.BaseCondition;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class TradeCondition extends BaseCondition {

	/**
	 * 订单编号
	*/
	private String tradeno;
	/**
	 * 订单编号列表
	*/
	private List<String> tradenoList;
	/**
	 * 门店编号
	*/
	private String shopcode;
	/**
	 * 客户编号
	*/
	private String usercode;
	/**
	 * 菜品编号
	*/
	private String goodids;
	/**
	 * 订单状态
	*/
	private Integer state;
	/**
	 * 订单价格
	*/
	private BigDecimal price;
	/**
	 * 创建人
	*/
	private String creater;
	/**
	 * 修改人
	*/
	private String updater;
}