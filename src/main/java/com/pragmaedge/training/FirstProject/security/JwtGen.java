package com.pragmaedge.training.FirstProject.security;

import org.springframework.stereotype.Component;

import com.pragmaedge.training.FirstProject.Models.UserData;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGen {
	public String generate(UserData jwtUser) {


        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUserId());
        claims.put("role", jwtUser.getRole());


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "youtube")
                .compact();
    }
}
