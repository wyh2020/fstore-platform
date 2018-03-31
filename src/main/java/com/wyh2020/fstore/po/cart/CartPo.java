package com.wyh2020.fstore.po.cart;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CartPo {

	/**
	 * 编号
	*/
	private String id;
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
	private String goodid;
	/**
	 * 菜品价格
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