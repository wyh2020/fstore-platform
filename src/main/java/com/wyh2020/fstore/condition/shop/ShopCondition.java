package com.wyh2020.fstore.condition.shop;

import com.wyh2020.fstore.base.condition.BaseCondition;
import lombok.Data;

import java.util.List;

@Data
public class ShopCondition extends BaseCondition {

	/**
	 * 门店编号
	*/
	private String shopcode;
	/**
	 * 门店编号列表
	*/
	private List<String> shopcodeList;
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
	 * 修改人
	*/
	private String updater;
}