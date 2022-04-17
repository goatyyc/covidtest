package com.example.covidtest.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: jwt工具类
 * @author: yyc
 * @time: 2022/4/14 21:51
 */
@Slf4j
public class JwtUtils {
    /**
     * 过期时间
     */
    private static final long EXPIRED_TIME = 60 * 60 * 24;

    private static final String jwtId = "tokenId";
    
    private static final String SECRET = "12345678";

    public static String generate(Map<String, Object> claims, Long time) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Date now = new Date(System.currentTimeMillis());

        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        //下面就是在为payload添加各种标准声明和私有声明了
        JwtBuilder builder = Jwts.builder() 
                .setClaims(claims)          
                .setId(jwtId)                 
                .setIssuedAt(now)           
                .signWith(signatureAlgorithm, secretKey);
        if (time >= 0) {
            long expMillis = nowMillis + time;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);     //设置过期时间
        }
        return builder.compact();
    }

    /**
     * 由字符串生成加密key
     *
     * @return
     */
    public static SecretKey generalKey() {
        String stringKey = SECRET;
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 验证token
     */
    public static Claims checkJwt(String token){
        SecretKey key = generalKey();
        Claims claims;
        try {
            claims = Jwts.parser()  
                    .setSigningKey(key)
                    .parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 根据userId生成token
     */
    public static String generateToken(Integer userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        return generate(map, EXPIRED_TIME);
    }

    /**
     * 根据token获取userId
     */
    public static int getUserIdByToken(String token){
        Claims claim = checkJwt(token);
        int userId = (int) claim.get("userId");
        return userId;
    }
    
    public static boolean isValid(String token){
        Claims claims = checkJwt(token);
        if(claims==null){
            return false;
        }
        Object userId = claims.get("userId");
        if(userId==null){
            return false;
        }
        return true;
    }
    
    public static int getCurrentUserId(HttpServletRequest request){
        // 获取request中的cookie中的token
        Cookie[] cookies = request.getCookies();
        int uid = 0;
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                log.info("token:{}",token);
                uid = JwtUtils.getUserIdByToken(token);
                log.info("userId:{}",uid);
            }
        }
        return uid;
    }

}
