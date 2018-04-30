package com.wyh2020.fstore.condition.classs;

import com.wyh2020.fstore.base.condition.BaseCondition;
import lombok.Data;

import java.util.List;

@Data
public class ClassCondition extends BaseCondition {

	/**
	 * ID 
	*/
	private Integer id;
	/**
	 * ID 列表
	*/
	private List<Integer> idList;
	/**
	 * 分类名称
	*/
	private String name;
	/**
	 * 状态 1 正常 9 删除
	*/
	private Integer state;
}