package com.wyh2020.fstore.vo.pwd;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel
public class PwdVo {

	@ApiModelProperty(value = "", required = true)
	private String id;

	@ApiModelProperty(value = "", required = false)
	private String usercode;

	@ApiModelProperty(value = "", required = false)
	private String loginpwd;

	@ApiModelProperty(value = "", required = false)
	private String paypwd;

	@ApiModelProperty(value = "", required = false)
	private String creater;

	@ApiModelProperty(value = "", required = false)
	private Date createtime;

	@ApiModelProperty(value = "", required = false)
	private String updater;

	@ApiModelProperty(value = "", required = false)
	private Date updatetime;

}