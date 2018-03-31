package com.wyh2020.fstore.form.pwd;

import com.wyh2020.fstore.base.form.BaseQueryForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class PwdQueryForm extends BaseQueryForm {

	@ApiModelProperty(value = "", required = false)
	private String id;

	@ApiModelProperty(value = "列表", required = false)
	private List<String> idList;

	@ApiModelProperty(value = "", required = false)
	private String usercode;

	@ApiModelProperty(value = "", required = false)
	private String loginpwd;

	@ApiModelProperty(value = "", required = false)
	private String paypwd;

	@ApiModelProperty(value = "", required = false)
	private String creater;

	@ApiModelProperty(value = "", required = false)
	private String updater;

}