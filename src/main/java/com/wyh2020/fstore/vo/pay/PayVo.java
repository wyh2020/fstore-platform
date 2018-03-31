package com.wyh2020.fstore.vo.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel
public class PayVo {

	@ApiModelProperty(value = "支付记录编号", required = true)
	private String id;

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

	@ApiModelProperty(value = "创建时间", required = false)
	private Date createtime;

	@ApiModelProperty(value = "修改人", required = false)
	private String updater;

	@ApiModelProperty(value = "修改时间", required = false)
	private Date updatetime;

}