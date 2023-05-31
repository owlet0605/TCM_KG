package com.example.tcm_kgsystem.service.Util;

import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtil {
    private static String SIGNATURE = "owlet0605";

    public static String getToken(Map<String,String> map){
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MINUTE,30);
        builder.withExpiresAt(instance.getTime());
        return builder.sign(Algorithm.HMAC256(SIGNATURE)).toString();
    }

    public static Boolean verify(String token){
        if(token!=null){
            try{
                JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
                return true;
            }catch (Exception e){
                return false;
            }
        }
        return false;
    }

    public static DecodedJWT getToken(String token){
        return JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
    }
}
