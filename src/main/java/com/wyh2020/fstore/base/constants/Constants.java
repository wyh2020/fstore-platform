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


    /**
     * 删除标示
     */
    interface DelFlag {
        /**
         * 未删除
         */
        int UN_DEL = 0;

        /**
         * 已删除
         */
        int DEL = 1;
    }
}
