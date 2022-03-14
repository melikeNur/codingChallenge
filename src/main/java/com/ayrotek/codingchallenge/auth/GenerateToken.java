package com.ayrotek.codingchallenge.auth;

import java.sql.Date;

import com.ayrotek.codingchallenge.response.GeneralResponse;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class GenerateToken {
    public static String generateToken(String email){
        String token = Jwts
        .builder()
        .setId("ayrotekJWT")
        .setSubject(email)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 600000))
        .signWith(SignatureAlgorithm.HS512,
                GeneralResponse.secretKey.getBytes()).compact();
        return "Bearer " +token;
    }
}
