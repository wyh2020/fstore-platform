package com.wyh2020.fstore.vo.classs;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class ClassVo {

	@ApiModelProperty(value = "ID ", required = true)
	private Integer id;

	@ApiModelProperty(value = "分类名称", required = false)
	private String name;

	@ApiModelProperty(value = "状态 1 正常 9 删除", required = false)
	private Integer state;

}