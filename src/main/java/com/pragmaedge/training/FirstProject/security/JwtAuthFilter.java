package com.pragmaedge.training.FirstProject.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.pragmaedge.training.FirstProject.Models.JwtAuthToken;


public class JwtAuthFilter extends AbstractAuthenticationProcessingFilter{

	public JwtAuthFilter() {
		super("/user/get/login");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		 String header = request.getHeader("Authorisation");


	        if (header == null || !header.startsWith("Check ")) {
	            throw new RuntimeException(" Token is missing");
	        }

	        String authenticationToken = header.substring(6);

	        JwtAuthToken token = new JwtAuthToken(authenticationToken);
	        return getAuthenticationManager().authenticate(token);
	}
	 @Override
	    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
	        super.successfulAuthentication(request, response, chain, authResult);
	        chain.doFilter(request, response);
	    }

}
