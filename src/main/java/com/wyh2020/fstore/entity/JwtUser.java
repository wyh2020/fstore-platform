package com.wyh2020.fstore.entity;


import lombok.Data;

@Data
public class JwtUser {
    private String phone;
    private String userCode;
    private Integer userType;
}
