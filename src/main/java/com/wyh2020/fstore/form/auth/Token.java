package com.wyh2020.fstore.form.auth;

import java.io.Serializable;

public class Token implements Serializable{
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
