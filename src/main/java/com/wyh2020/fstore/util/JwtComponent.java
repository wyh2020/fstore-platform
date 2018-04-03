package com.wyh2020.fstore.util;

import com.wyh2020.fstore.base.constants.Constants;
import com.wyh2020.fstore.exception.GateWayException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class JwtComponent {

    /**
     * 获取会话
     *
     * @param request
     * @return
     * @throws JwtComponent
     */
    public Claims getClaims(HttpServletRequest request) throws GateWayException {

        String authHeader = request.getHeader("Authorization");
        if(StringUtils.isBlank(authHeader)){
            authHeader = request.getParameter("token");
        }
        // 没有登陆信息
        if (StringUtils.isBlank(authHeader)) {
            return null;
        }
        //JWT token验证
        Claims claims = Jwts.parser().setSigningKey(Constants.JWT_SECRET)
                .parseClaimsJws(authHeader).getBody();

        return claims;
    }


    /**
     * 获取会话
     *
     * @param token
     * @return
     * @throws JwtComponent
     */
    public Claims getClaims(String token) throws GateWayException {

        // 没有登陆信息
        if (StringUtils.isBlank(token)) {
            return null;
        }
        //JWT token验证
        Claims claims = Jwts.parser().setSigningKey(Constants.JWT_SECRET)
                .parseClaimsJws(token).getBody();

        return claims;
    }
    /**
     * 清除会话
     *
     * @param request
     * @throws JwtComponent
     */
    public void evictToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        // 没有登陆信息
        if (StringUtils.isBlank(authHeader)) {
            return;
        }
    }



    /**
     * 生成会话token
     * @return
     */
    public String createToken(String userCode, String phone,Integer userType) {
        Date expDate = new Date(System.currentTimeMillis()+ Constants.ExpTime.UserExpTime);

        String token = Jwts.builder().setSubject(userCode).setExpiration(expDate)
                .claim("phone", phone)
                .claim("userCode", userCode)
                .claim("userType", userType)
                .signWith(SignatureAlgorithm.HS256, Constants.JWT_SECRET).compact();

        return token;
    }
}
