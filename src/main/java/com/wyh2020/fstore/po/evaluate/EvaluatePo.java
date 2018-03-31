package com.wyh2020.fstore.po.evaluate;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class EvaluatePo {

	/**
	 * 评价编号
	*/
	private String id;
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
	 * 评价分数
	*/
	private Integer score;
	/**
	 * 评价描述
	*/
	private String des;
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