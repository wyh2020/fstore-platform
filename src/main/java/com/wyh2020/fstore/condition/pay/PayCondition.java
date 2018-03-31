package com.wyh2020.fstore.condition.pay;

import com.wyh2020.fstore.base.condition.BaseCondition;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PayCondition extends BaseCondition {

	/**
	 * 支付记录编号
	*/
	private String id;
	/**
	 * 支付记录编号列表
	*/
	private List<String> idList;
	/**
	 * 订单编号
	*/
	private String tradeno;
	/**
	 * 客户编号
	*/
	private String usercode;
	/**
	 * 门店编号
	*/
	private String shopcode;
	/**
	 * 菜品编号
	*/
	private String goodids;
	/**
	 * 订单价格
	*/
	private BigDecimal price;
	/**
	 * 支付方式
	*/
	private Integer payment;
	/**
	 * 创建人
	*/
	private String creater;
	/**
	 * 修改人
	*/
	private String updater;
}