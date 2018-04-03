package com.wyh2020.fstore.form.auth;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

@Data
public class UpdatePswForm {

    @ApiModelProperty(value = "密码",required = true)
    @NotEmpty(message = "密码不能为空")
    @Size(min = 64,max = 64,message = "密码输入长度不正确")
    private String password;

    @ApiModelProperty(value = "旧密码",required = true)
    @NotEmpty(message = "旧密码不能为空")
    @Size(min = 64,max = 64,message = "旧密码输入长度不正确")
    private String oldPwd;

    @ApiModelProperty(value = "确认密码",required = true)
    @NotEmpty(message = "确认密码不能为空")
    @Size(min = 64,max = 64,message = "确认密码输入长度不正确")
    private String confirmPassword;
}
