package com.wyh2020.fstore.condition.pwd;

import com.wyh2020.fstore.base.condition.BaseCondition;
import lombok.Data;

import java.util.List;

@Data
public class PwdCondition extends BaseCondition {

	/**
	 * 
	*/
	private String id;
	/**
	 * 列表
	*/
	private List<String> idList;
	/**
	 * 
	*/
	private String usercode;
	/**
	 * 
	*/
	private String loginpwd;
	/**
	 * 
	*/
	private String paypwd;
	/**
	 * 
	*/
	private String creater;
	/**
	 * 
	*/
	private String updater;
}