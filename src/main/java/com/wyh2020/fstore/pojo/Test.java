package com.wyh2020.fstore.pojo;

import java.io.Serializable;

/**
 * Created with wyh.
 * Date: 2017/7/2
 * Time: 上午12:52
 */
public class Test implements Serializable{

    private int id;

    private String name;

    private int age;

    private int sum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String toString() {
        return "id==" + getId() + "; name==" + getName() + "; age==" + getAge() + "; sum==" + getSum();
    }
}
