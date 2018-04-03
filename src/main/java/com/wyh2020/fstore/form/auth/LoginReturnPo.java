package com.wyh2020.fstore.form.auth;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginReturnPo implements Serializable{

    private Object user;

    private String token;

}
