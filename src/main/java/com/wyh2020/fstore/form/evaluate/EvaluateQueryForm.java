package com.wyh2020.fstore.form.evaluate;

import com.wyh2020.fstore.base.form.BaseQueryForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel
public class EvaluateQueryForm extends BaseQueryForm {

	@ApiModelProperty(value = "评价编号", required = false)
	private String id;

	@ApiModelProperty(value = "评价编号列表", required = false)
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

	@ApiModelProperty(value = "评价分数", required = false)
	private Integer score;

	@ApiModelProperty(value = "评价描述", required = false)
	private String des;

	@ApiModelProperty(value = "创建人", required = false)
	private String creater;

	@ApiModelProperty(value = "修改人", required = false)
	private String updater;

}