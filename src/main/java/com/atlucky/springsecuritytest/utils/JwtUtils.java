package com.atlucky.springsecuritytest.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * @Date 2023/8/11 17:34
 * @Author XiaoHu
 * @Description
 **/
@Slf4j
public class JwtUtils {
    public static final Long JWT_TTL = 60*60*1000L;
    public static final String JWT_KEY= "jwtkey";
    public static String getUUID(){
        String token = UUID.randomUUID().toString().replace("-", "");
        return token;
    }
    public static String createJwt(String subject){
        JwtBuilder builder = getJwtBuilder(subject, null, getUUID());
        return builder.compact();
    }
    public static String createJwt(String subject,Long ttlMillis){
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, getUUID());
        return builder.compact();
    }
    private static JwtBuilder getJwtBuilder(String subject,Long ttlMillis,String uuid){
        SignatureAlgorithm algorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generaKey();
        long millis = System.currentTimeMillis();
        Date startDate = new Date(millis);
        if(ttlMillis==null){
            ttlMillis=JwtUtils.JWT_TTL;
        }
        long expMills = millis + ttlMillis;
        Date expDate = new Date(expMills);
        return Jwts.builder().setId(uuid)
                .setSubject(subject)
                .setIssuer("admin")
                .setIssuedAt(startDate)
                .signWith(algorithm,secretKey)
                .setExpiration(expDate);
    }
    public static String createJwt(String id,String subject,Long ttlMills){
        JwtBuilder builder = getJwtBuilder(subject, ttlMills, id);
        return builder.compact();
    }

    private static SecretKey generaKey() {
        byte[] decode = Base64.getDecoder().decode(JwtUtils.JWT_KEY);
        SecretKey key = new SecretKeySpec(decode, 0, decode.length,"AES");
        return key;
    }
    public static Claims praseJwt(String Jwt) throws Exception{
        SecretKey secretKey = generaKey();
        return Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(Jwt)
                .getBody();
    }

   /* public static void main(String[] args) throws Exception {
        String jwt = createJwt("12345");
        Claims claims = praseJwt(jwt);
        claims.getSubject();
        log.info("{}",jwt);
        log.info("{}",claims.getSubject());
    }*/
}
