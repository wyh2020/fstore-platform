package com.wyh2020.fstore.vo.good;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel
public class GoodVo {

	@ApiModelProperty(value = "菜品编号", required = true)
	private String goodid;

	@ApiModelProperty(value = "门店编号", required = false)
	private String shopcode;

	@ApiModelProperty(value = "菜品图片地址", required = false)
	private String img;

	@ApiModelProperty(value = "菜名", required = false)
	private String name;

	@ApiModelProperty(value = "菜类型", required = false)
	private Integer type;

	@ApiModelProperty(value = "价格", required = false)
	private BigDecimal price;

	@ApiModelProperty(value = "创建人", required = false)
	private String creater;

	@ApiModelProperty(value = "创建时间", required = false)
	private Date createtime;

	@ApiModelProperty(value = "修改人", required = false)
	private String updater;

	@ApiModelProperty(value = "修改时间", required = false)
	private Date updatetime;

}