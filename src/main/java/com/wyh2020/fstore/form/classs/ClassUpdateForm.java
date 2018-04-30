package com.wyh2020.fstore.form.classs;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel
public class ClassUpdateForm {

	@ApiModelProperty(value = "ID ", required = true)
	@NotNull(message = "ID 不能为空")
	private Integer id;

	@ApiModelProperty(value = "分类名称", required = false)
	private String name;

	@ApiModelProperty(value = "状态 1 正常 9 删除", required = false)
	private Integer state;

}