package com.wyh2020.fstore.form.shop;

import com.wyh2020.fstore.util.DateUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel
public class ShopUpdateForm {

	@ApiModelProperty(value = "门店编号", required = true)
	@NotEmpty(message = "门店编号不能为空")
	private String shopcode;

	@ApiModelProperty(value = "门店名称", required = false)
	private String shopname;

	@ApiModelProperty(value = "管理员编号", required = false)
	private String usercode;

	@ApiModelProperty(value = "门店地址", required = false)
	private String address;

	@ApiModelProperty(value = "联系方式", required = false)
	private String tel;

	@ApiModelProperty(value = "描述", required = false)
	private String des;

	@ApiModelProperty(value = "创建人", required = false)
	private String creater;

	@ApiModelProperty(value = "创建时间,格式为:" + DateUtil.FORMAT, required = false)
	@DateTimeFormat(pattern = DateUtil.FORMAT)
	private Date createtime;

	@ApiModelProperty(value = "修改人", required = false)
	private String updater;

	@ApiModelProperty(value = "修改时间,格式为:" + DateUtil.FORMAT, required = false)
	@DateTimeFormat(pattern = DateUtil.FORMAT)
	private Date updatetime;

}