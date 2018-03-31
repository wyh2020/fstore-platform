package com.wyh2020.fstore.vo.shop;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel
public class ShopVo {

	@ApiModelProperty(value = "门店编号", required = true)
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

	@ApiModelProperty(value = "创建时间", required = false)
	private Date createtime;

	@ApiModelProperty(value = "修改人", required = false)
	private String updater;

	@ApiModelProperty(value = "修改时间", required = false)
	private Date updatetime;

}