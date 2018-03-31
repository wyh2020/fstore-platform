package com.wyh2020.fstore.po.user;

import lombok.Data;

import java.util.Date;

@Data
public class UserPo {

	/**
	 * 用户编号
	*/
	private String usercode;
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