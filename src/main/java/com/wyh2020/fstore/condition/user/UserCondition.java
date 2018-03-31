package com.wyh2020.fstore.condition.user;

import com.wyh2020.fstore.base.condition.BaseCondition;
import lombok.Data;

import java.util.List;

@Data
public class UserCondition extends BaseCondition {

	/**
	 * 用户编号
	*/
	private String usercode;
	/**
	 * 用户编号列表
	*/
	private List<String> usercodeList;
	/**
	 * 姓名
	*/
	private String name;
	/**
	 * 手机号
	*/
	private String phone;
	/**
	 * 性别 1、男 2、女
	*/
	private Integer sex;
	/**
	 * 用户类型 1、超级管理员 2、商户 3、客户
	*/
	private Integer type;
	/**
	 * 
	*/
	private Integer state;
	/**
	 * 创建人
	*/
	private String creater;
	/**
	 * 修改人
	*/
	private String updater;
}