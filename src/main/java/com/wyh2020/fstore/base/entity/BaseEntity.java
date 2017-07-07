package com.wyh2020.fstore.base.entity;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * Created with wyh.
 * Date: 2017/7/5
 * Time: 下午2:30
 */
public class BaseEntity implements Serializable{

    public static final long serialVersionUID = 1L;


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
