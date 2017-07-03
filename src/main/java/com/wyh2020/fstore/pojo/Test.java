package com.wyh2020.fstore.pojo;

/**
 * Created with wyh.
 * Date: 2017/7/2
 * Time: 上午12:52
 */
public class Test {

    private int id;

    private String name;

    private int age;

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


    public String toString(){
        return "id==" + getId() + "; name==" + getName() + "; age==" + getAge();
    }
}
