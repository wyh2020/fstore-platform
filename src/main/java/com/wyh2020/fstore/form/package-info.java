/**
 * 开发规范：<br />
 * 1、类上必须加ApiModel(description = "*") <br />
 * 2、如果是查询Form需要分页功能，必须继承BaseQueryForm <br />
 * 3、属性上必须添加@ApiModelProperty(value = "*")，如果是必传参数必须添加required = true <br />
 * 4、所有属性的基本校验（为空、大小范围、长度等）必须通过注解来完成，如果存在子form，需要添加@Valid进行嵌套校验 <br />
 * 5、Date属性根据格式'yyyy-MM-dd HH:mm:ss，则使用@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8"),且在@ApiModelProperty描述里注解格式 <br />
 */
package com.wyh2020.fstore.form;
