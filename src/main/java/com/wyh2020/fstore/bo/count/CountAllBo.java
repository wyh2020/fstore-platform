package com.wyh2020.fstore.bo.count;

import lombok.Data;

@Data
public class CountAllBo {

	/**
	 * 用户统计
	 */
	private Integer countUser;


	/**
	 * 店铺统计
	 */
	private Integer countShop;


	/**
	 * 订单统计
	 */
	private Integer countTrade;


	/**
	 * 菜品统计
	 */
	private Integer countGood;



}