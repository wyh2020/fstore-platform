package com.wyh2020.fstore.form.trade;

import com.wyh2020.fstore.base.form.BaseQueryForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel
public class TradeQueryForm extends BaseQueryForm {

	@ApiModelProperty(value = "订单编号", required = false)
	private String tradeno;

	@ApiModelProperty(value = "订单编号列表", required = false)
	private List<String> tradenoList;

	@ApiModelProperty(value = "门店编号", required = false)
	private String shopcode;

	@ApiModelProperty(value = "客户编号", required = false)
	private String usercode;

	@ApiModelProperty(value = "菜品编号", required = false)
	private String goodids;

	@ApiModelProperty(value = "订单状态", required = false)
	private Integer state;

	@ApiModelProperty(value = "订单价格", required = false)
	private BigDecimal price;

	@ApiModelProperty(value = "创建人", required = false)
	private String creater;

	@ApiModelProperty(value = "修改人", required = false)
	private String updater;

}