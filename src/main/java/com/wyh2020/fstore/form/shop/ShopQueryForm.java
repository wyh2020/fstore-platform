package com.wyh2020.fstore.form.shop;

import com.wyh2020.fstore.base.form.BaseQueryForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class ShopQueryForm extends BaseQueryForm {

	@ApiModelProperty(value = "门店编号", required = false)
	private String shopcode;

	@ApiModelProperty(value = "门店编号列表", required = false)
	private List<String> shopcodeList;

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

	@ApiModelProperty(value = "修改人", required = false)
	private String updater;

}