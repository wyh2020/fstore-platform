package com.wyh2020.fstore.po.good;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class GoodPo {

	/**
	 * 菜品编号
	*/
	private String goodid;
	/**
	 * 门店编号
	*/
	private String shopcode;
	/**
	 * 菜品图片地址
	*/
	private String img;
	/**
	 * 菜名
	*/
	private String name;
	/**
	 * 菜类型
	*/
	private Integer type;
	/**
	 * 价格
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