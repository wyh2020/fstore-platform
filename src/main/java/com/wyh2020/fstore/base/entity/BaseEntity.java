package com.wyh2020.fstore.base.entity;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class BaseEntity implements Serializable{

    public static final long serialVersionUID = 1L;


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
