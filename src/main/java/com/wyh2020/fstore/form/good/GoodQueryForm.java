package com.wyh2020.fstore.form.good;

import com.wyh2020.fstore.base.form.BaseQueryForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel
public class GoodQueryForm extends BaseQueryForm {

	@ApiModelProperty(value = "菜品编号", required = false)
	private String goodid;

	@ApiModelProperty(value = "菜品编号列表", required = false)
	private List<String> goodidList;

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

	@ApiModelProperty(value = "修改人", required = false)
	private String updater;

}