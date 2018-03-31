package com.wyh2020.fstore.condition.good;

import com.wyh2020.fstore.base.condition.BaseCondition;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class GoodCondition extends BaseCondition {

	/**
	 * 菜品编号
	*/
	private String goodid;
	/**
	 * 菜品编号列表
	*/
	private List<String> goodidList;
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
	 * 修改人
	*/
	private String updater;
}