package com.wyh2020.fstore.condition.cart;

import com.wyh2020.fstore.base.condition.BaseCondition;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CartCondition extends BaseCondition {

	/**
	 * 编号
	*/
	private String id;
	/**
	 * 编号列表
	*/
	private List<String> idList;
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
	 * 商品数量
	 */
	private Integer sum;
	/**
	 * 菜品价格
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