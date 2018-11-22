 package com.pragmaedge.training.FirstProject.Models;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@SuppressWarnings("serial")
public class JwtAuthToken extends UsernamePasswordAuthenticationToken {

	private String token;
	public JwtAuthToken(String token) {
		super(null,null);
		this.setToken(token);
		// TODO Auto-generated constructor stub
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

}
