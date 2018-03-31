package com.wyh2020.fstore.form.cart;

import com.wyh2020.fstore.base.form.BaseQueryForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel
public class CartQueryForm extends BaseQueryForm {

	@ApiModelProperty(value = "编号", required = false)
	private String id;

	@ApiModelProperty(value = "编号列表", required = false)
	private List<String> idList;

	@ApiModelProperty(value = "客户编号", required = false)
	private String usercode;

	@ApiModelProperty(value = "门店编号", required = false)
	private String shopcode;

	@ApiModelProperty(value = "菜品编号", required = false)
	private String goodid;

	@ApiModelProperty(value = "菜品价格", required = false)
	private BigDecimal price;

	@ApiModelProperty(value = "创建人", required = false)
	private String creater;

	@ApiModelProperty(value = "修改人", required = false)
	private String updater;

}