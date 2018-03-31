package com.wyh2020.fstore.base.bean.role.identity;

import lombok.Data;

/**
 * Created by hzh on 2018/3/31.
 */

@Data
public class IdentityUser {

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 用户类型
     */
    private Integer userType;
}
