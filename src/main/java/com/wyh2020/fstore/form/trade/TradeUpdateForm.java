package com.wyh2020.fstore.form.trade;

import com.wyh2020.fstore.util.DateUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel
public class TradeUpdateForm {

	@ApiModelProperty(value = "订单编号", required = true)
	@NotEmpty(message = "订单编号不能为空")
	private String tradeno;

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

	@ApiModelProperty(value = "创建时间,格式为:" + DateUtil.FORMAT, required = false)
	@DateTimeFormat(pattern = DateUtil.FORMAT)
	private Date createtime;

	@ApiModelProperty(value = "修改人", required = false)
	private String updater;

	@ApiModelProperty(value = "修改时间,格式为:" + DateUtil.FORMAT, required = false)
	@DateTimeFormat(pattern = DateUtil.FORMAT)
	private Date updatetime;

}