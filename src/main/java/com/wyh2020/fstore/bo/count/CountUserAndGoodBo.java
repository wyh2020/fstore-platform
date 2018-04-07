package com.wyh2020.fstore.bo.count;

import lombok.Data;

import java.util.Map;

@Data
public class CountUserAndGoodBo {

	/**
	 * 用户统计
	 */
	private Map<Integer,Long> userMap;


	/**
	 * 菜品统计
	 */
	private Map<Integer,Long> goodMap;

}