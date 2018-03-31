package com.wyh2020.fstore.base.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.StringTokenizer;

/**
 * ip地址工具类
 *
 * @see
 */
public final class IPUtil {
    private static Logger logger = LoggerFactory.getLogger(com.wyh2020.fstore.base.util.IPUtil.class);
    /**
     * IP长度
     */
    private static final int IPLENGTH = 4;

    private IPUtil() {

    }

    /**
     * 获取客户端ip
     */
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        String xip = request.getHeader("x-forwarded-for");

        if (!checkIP(ip)) {
            ip = request.getHeader("REMOTE-HOST");
        }

        if (StringUtils.isNotBlank(ip) && !ip.equals(xip)) {
            logger.warn("getipne   X-Real-IP  " + ip + "    ,x-forwarded-for " + xip);
        }

        if (!checkIP(ip) || !ip.equals(xip)) {
            String info = request.getHeader("x-forwarded-for");
            if (StringUtils.isNotBlank(info)) {
                String[] ips = info.trim().split(",");
                for (String s : ips) {
                    if (!"unknown".equalsIgnoreCase(s)) {//取第一个非unknown的ip地址
                        ip = s;
                        break;
                    }
                }
            }
        }
        if (!checkIP(ip)) {
            ip = request.getHeader("Proxy-Client-IP");//只在 Apache（Weblogic Plug-In Enable）+WebLogic 搭配下出现
        }
        if (!checkIP(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");//只在 Apache（Weblogic Plug-In Enable）+WebLogic 搭配下出现
        }
        if (!checkIP(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (!checkIP(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (!checkIP(ip)) {
            ip = request.getRemoteAddr();
        }

        // 多级反向代理
        if (null != ip && !"".equals(ip.trim())) {
            StringTokenizer st = new StringTokenizer(ip, ",");
            if (st.countTokens() > 1) {
                logger.warn("getip StringTokenizer  " + ip);
                return st.nextToken();
            }
        }

        return ip;
    }

    /**
     * 验证ip地址格式是否正确
     *
     * @param ip
     * @return
     * @author lihe 2013-7-4 下午5:26:26
     * @see
     */
    private static boolean checkIP(String ip) {
        if (StringUtils.isNotBlank(ip) && ip.split("\\.").length == IPLENGTH) {
            return true;
        }
        return false;
    }

}