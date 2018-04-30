package com.wyh2020.fstore.po.classs;

import lombok.Data;

@Data
public class ClassPo {

	/**
	 * ID 
	*/
	private Integer id;
	/**
	 * 分类名称
	*/
	private String name;
	/**
	 * 状态 1 正常 9 删除
	*/
	private Integer state;
}