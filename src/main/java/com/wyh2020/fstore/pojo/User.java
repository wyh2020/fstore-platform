package com.wyh2020.fstore.pojo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created with wyh.
 * Date: 2017/7/4
 * Time: 下午5:45
 */
@Data
@Document
public class User implements Serializable {


    private static final long serialVersionUID = 1L;


    private String id;


    private String name;


    private int age;


    private String password;
}
