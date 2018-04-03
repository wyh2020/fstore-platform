package com.wyh2020.fstore.base.constants;

/**
 * Created by hzh on 2018/3/31.
 */
public interface Constants {

    String LOGIN_TOKEN = "Authorization";

    /**
     * json格式登录身份
     */
    String JWT_JSON = "jwtjson";


    final String JWT_SECRET = "hzhkey";



    interface ExpTime {
        /**
         * User的超时时间
         */
        int UserExpTime = 10 * 24 * 60 * 60 * 1000;
        /**
         * 判断超时时间
         */
        int JudgeExpTime = 20 * 60 * 1000;
    }

    /**
     * 用户类型 1、超级管理员 2、商户 3、客户
     */
    interface UserType {
        /**
         * 超级管理员
         */
        int ADMIN = 1;

        /**
         * 商户
         */
        int SHOP = 2;

        /**
         * 客户
         */
        int CUSTOMER = 3;

    }


    /**
     * 用户状态 1、正常 2、已禁用 3、已删除
     * normal disabled deleted
     */
    interface UserState {
        /**
         * 正常
         */
        int NORMAL = 1;

        /**
         * 已禁用
         */
        int DISABLED = 2;

        /**
         * 已删除
         */
        int DELETED = 3;

    }
}
