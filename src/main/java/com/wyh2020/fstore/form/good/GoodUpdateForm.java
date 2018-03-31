package com.wyh2020.fstore.form.good;

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
public class GoodUpdateForm {

	@ApiModelProperty(value = "菜品编号", required = true)
	@NotEmpty(message = "菜品编号不能为空")
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

	@ApiModelProperty(value = "创建时间,格式为:" + DateUtil.FORMAT, required = false)
	@DateTimeFormat(pattern = DateUtil.FORMAT)
	private Date createtime;

	@ApiModelProperty(value = "修改人", required = false)
	private String updater;

	@ApiModelProperty(value = "修改时间,格式为:" + DateUtil.FORMAT, required = false)
	@DateTimeFormat(pattern = DateUtil.FORMAT)
	private Date updatetime;

}