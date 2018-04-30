package com.wyh2020.fstore.bo.trade;

import com.wyh2020.fstore.po.good.GoodPo;
import com.wyh2020.fstore.po.shop.ShopPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@ApiModel
public class TradeBo {

	@ApiModelProperty(value = "订单编号", required = true)
	private String tradeno;

	@ApiModelProperty(value = "门店编号", required = false)
	private String shopcode;

	@ApiModelProperty(value = "客户编号", required = false)
	private String usercode;

	@ApiModelProperty(value = "菜品编号", required = false)
	private String goodids;

	@ApiModelProperty(value = "每种菜品的数量", required = false)
	private String sums;

	@ApiModelProperty(value = "订单状态", required = false)
	private Integer state;

	@ApiModelProperty(value = "订单价格", required = false)
	private BigDecimal price;

	@ApiModelProperty(value = "创建人", required = false)
	private String creater;

	@ApiModelProperty(value = "创建时间", required = false)
	private Date createtime;

	@ApiModelProperty(value = "修改人", required = false)
	private String updater;

	@ApiModelProperty(value = "修改时间", required = false)
	private Date updatetime;

	private List<GoodPo> goodList;

	/**
	 * 评价状态
	 */
	private Integer evaluateState;


	/**
	 * 店铺信息
	 */
	private ShopPo shopPo;

}