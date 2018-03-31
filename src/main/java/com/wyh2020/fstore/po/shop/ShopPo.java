package com.wyh2020.fstore.po.shop;

import lombok.Data;

import java.util.Date;

@Data
public class ShopPo {

	/**
	 * 门店编号
	*/
	private String shopcode;
	/**
	 * 门店名称
	*/
	private String shopname;
	/**
	 * 管理员编号
	*/
	private String usercode;
	/**
	 * 门店地址
	*/
	private String address;
	/**
	 * 联系方式
	*/
	private String tel;
	/**
	 * 描述
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