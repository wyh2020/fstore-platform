package com.wyh2020.fstore.base;


import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by hzh on 2018/3/31.
 */
public abstract class BaseSerializable implements Serializable{
    public BaseSerializable(){

    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
