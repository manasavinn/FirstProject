package com.pragmaedge.training.FirstProject.security;

import org.springframework.stereotype.Component;

import com.pragmaedge.training.FirstProject.Models.UserData;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtVal {
     private String secret="youtube";
     public UserData validate(String token)
     {
    	UserData user=null;
    	try {
		Claims body=Jwts.parser().setSigningKey(secret).
				parseClaimsJws(token)
				.getBody();
		user=new UserData();
		user.setUserId(body.getSubject());
		user.setRole((String)body.get("role"));
    	}
    	catch(Exception e)
    	{
    		System.out.print(e);
    	}
    	return user;
     }
}
