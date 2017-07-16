package com.wyh2020.fstore.learning.reflect;

import java.lang.reflect.Method;

/**
 * Created with wyh.
 * Date: 2017/7/14
 * Time: 下午5:37
 */
public class ReflectDemo {



    public static void main(String[] args) throws ClassNotFoundException {
        //第一种：Class c1 = Code.class;
//        Class class1 = Test.class;
//        System.out.println("class1 ===" + class1);
//
//        //第二种：Class c2 = code1.getClass();
//        Test test = new Test();
//        Class class2 = test.getClass();
//        System.out.println("class2 ===" + class2);
//
//        //第三种：Class c3 = Class.forName("com.trigl.reflect.Code");
//        Class class3 = Class.forName("com.wyh2020.fstore.learning.reflect.Test");
//        System.out.println("class3 ===" + class3);


        Class classType = Class.forName("java.lang.String");
        Method[] methods = classType.getDeclaredMethods();
        for(Method method: methods){
            System.out.println(method);
        }





    }
}
