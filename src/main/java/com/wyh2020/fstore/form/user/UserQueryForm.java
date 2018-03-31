package com.wyh2020.fstore.form.user;

import com.wyh2020.fstore.base.form.BaseQueryForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class UserQueryForm extends BaseQueryForm {

	@ApiModelProperty(value = "用户编号", required = false)
	private String usercode;

	@ApiModelProperty(value = "用户编号列表", required = false)
	private List<String> usercodeList;

	@ApiModelProperty(value = "姓名", required = false)
	private String name;

	@ApiModelProperty(value = "手机号", required = false)
	private String phone;

	@ApiModelProperty(value = "性别 1、男 2、女", required = false)
	private Integer sex;

	@ApiModelProperty(value = "用户类型 1、超级管理员 2、商户 3、客户", required = false)
	private Integer type;

	@ApiModelProperty(value = "", required = false)
	private Integer state;

	@ApiModelProperty(value = "创建人", required = false)
	private String creater;

	@ApiModelProperty(value = "修改人", required = false)
	private String updater;

}