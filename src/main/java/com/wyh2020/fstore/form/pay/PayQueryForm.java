package com.wyh2020.fstore.form.pay;

import com.wyh2020.fstore.base.form.BaseQueryForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel
public class PayQueryForm extends BaseQueryForm {

	@ApiModelProperty(value = "支付记录编号", required = false)
	private String id;

	@ApiModelProperty(value = "支付记录编号列表", required = false)
	private List<String> idList;

	@ApiModelProperty(value = "订单编号", required = false)
	private String tradeno;

	@ApiModelProperty(value = "客户编号", required = false)
	private String usercode;

	@ApiModelProperty(value = "门店编号", required = false)
	private String shopcode;

	@ApiModelProperty(value = "菜品编号", required = false)
	private String goodids;

	@ApiModelProperty(value = "订单价格", required = false)
	private BigDecimal price;

	@ApiModelProperty(value = "支付方式", required = false)
	private Integer payment;

	@ApiModelProperty(value = "创建人", required = false)
	private String creater;

	@ApiModelProperty(value = "修改人", required = false)
	private String updater;

}