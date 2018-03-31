package com.wyh2020.fstore.po.trade;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TradePo {

	/**
	 * 订单编号
	*/
	private String tradeno;
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
	 * 创建时间
	*/
	private Date createtime;
	/**
	 * 修改人
	*/
	private String updater;
	/**
	 * 修改时间
	*/
	private Date updatetime;
}