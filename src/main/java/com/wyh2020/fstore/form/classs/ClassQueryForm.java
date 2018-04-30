package com.wyh2020.fstore.form.classs;

import com.wyh2020.fstore.base.form.BaseQueryForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class ClassQueryForm extends BaseQueryForm {

	@ApiModelProperty(value = "ID ", required = false)
	private Integer id;

	@ApiModelProperty(value = "ID 列表", required = false)
	private List<Integer> idList;

	@ApiModelProperty(value = "分类名称", required = false)
	private String name;

	@ApiModelProperty(value = "状态 1 正常 9 删除", required = false)
	private Integer state;

}