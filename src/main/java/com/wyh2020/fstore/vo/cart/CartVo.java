package com.wyh2020.fstore.vo.cart;

import com.wyh2020.fstore.po.good.GoodPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel
public class CartVo {

	@ApiModelProperty(value = "编号", required = true)
	private String id;

	@ApiModelProperty(value = "客户编号", required = false)
	private String usercode;

	@ApiModelProperty(value = "门店编号", required = false)
	private String shopcode;

	@ApiModelProperty(value = "菜品编号", required = false)
	private String goodid;

	@ApiModelProperty(value = "菜品数量", required = false)
	private Integer sum;

	@ApiModelProperty(value = "菜品价格", required = false)
	private BigDecimal price;

	@ApiModelProperty(value = "创建人", required = false)
	private String creater;

	@ApiModelProperty(value = "创建时间", required = false)
	private Date createtime;

	@ApiModelProperty(value = "修改人", required = false)
	private String updater;

	@ApiModelProperty(value = "修改时间", required = false)
	private Date updatetime;

	@ApiModelProperty(value = "GoodPo", required = false)
	private GoodPo goodPo;



}