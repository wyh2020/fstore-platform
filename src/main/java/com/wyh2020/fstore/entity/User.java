package com.wyh2020.fstore.entity;

import com.wyh2020.fstore.base.entity.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created with wyh.
 * Date: 2017/7/5
 * Time: 下午2:47
 */
@Data
@Document
public class User extends BaseEntity{

    private static final long serialVersionUID = 1L;


    private String id;


    private String name;


    private int age;


    private String password;
}
