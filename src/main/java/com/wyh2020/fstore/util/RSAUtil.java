package com.wyh2020.fstore.util;

import com.wyh2020.fstore.base.util.HexUtil;

import java.math.BigInteger;

public class RSAUtil {

    private static BigInteger private_d = new BigInteger(
            "3206586642942415709865087389521403230384599658161226562177807849299468150139");
    private static BigInteger n = new BigInteger(
            "7318321375709168120463791861978437703461807315898125152257493378072925281977");


    /**
     * 登陆的密码解密
     *
     * @param str
     * @return
     */
    public static String decryptPassword(String str) {
        byte ptext[] = HexUtil.toByteArray(str);
        BigInteger encry_c = new BigInteger(ptext);

        BigInteger private_m = encry_c.modPow(private_d, n);
        // 计算明文对应的字符串
        byte[] mt = private_m.toByteArray();
        StringBuffer buffer = new StringBuffer();
        for (int i = mt.length - 1; i > -1; i--) {
            buffer.append((char) mt[i]);
        }

        return buffer.toString();
    }

}
