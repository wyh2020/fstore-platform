package com.wyh2020.fstore.form.pwd;

import com.wyh2020.fstore.util.DateUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel
public class PwdUpdateForm {

	@ApiModelProperty(value = "", required = true)
	@NotEmpty(message = "不能为空")
	private String id;

	@ApiModelProperty(value = "", required = false)
	private String usercode;

	@ApiModelProperty(value = "", required = false)
	private String loginpwd;

	@ApiModelProperty(value = "", required = false)
	private String paypwd;

	@ApiModelProperty(value = "", required = false)
	private String creater;

	@ApiModelProperty(value = ",格式为:" + DateUtil.FORMAT, required = false)
	@DateTimeFormat(pattern = DateUtil.FORMAT)
	private Date createtime;

	@ApiModelProperty(value = "", required = false)
	private String updater;

	@ApiModelProperty(value = ",格式为:" + DateUtil.FORMAT, required = false)
	@DateTimeFormat(pattern = DateUtil.FORMAT)
	private Date updatetime;

}