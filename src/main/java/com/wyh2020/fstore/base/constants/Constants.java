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

    /**
     * 菜系
     * 1 鲁菜、2 川菜、3 粤菜、4 闽菜、5 苏菜、6 浙菜、7 湘菜、8 徽菜
     */
    interface Cuisines {
        /**
         * ShandongCuisine 鲁菜
         */
        int ShandongCuisine = 1;

        /**
         * SichuanCuisine 川菜
         */
        int SichuanCuisine = 2;

        /**
         * GuangdongCuisine 粤菜
         */
        int GuangdongCuisine = 3;

        /**
         * FujianCuisine 闽菜
         */
        int FujianCuisine = 4;

        /**
         * JiangsuCuisine 苏菜
         */
        int JiangsuCuisine = 5;

        /**
         * ZhejiangCuisine 浙菜
         */
        int ZhejiangCuisine = 6;

        /**
         * HunanCuisine 湘菜
         */
        int HunanCuisine = 7;

        /**
         * AnhuiCuisine 徽菜
         */
        int AnhuiCuisine = 8;

    }


    interface TradeState {

        /**
         * 未支付
         */
        int UnPay = 1;

        /**
         * 已支付
         */
        int Payed = 2;

        /**
         * 已取消
         */
        int Cancle = 3;

        /**
         * 已删除
         */
        int Del = 9;

    }


    interface EvaluateState {

        /**
         * 未评价
         */
        int UnEvaluate = 1;

        /**
         * 已评价
         */
        int Evaluated = 2;

    }



}
