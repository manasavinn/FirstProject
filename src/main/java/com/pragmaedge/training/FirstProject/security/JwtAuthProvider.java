package com.pragmaedge.training.FirstProject.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.pragmaedge.training.FirstProject.Models.JwtAuthToken;
import com.pragmaedge.training.FirstProject.Models.UserData;
import com.pragmaedge.training.FirstProject.Models.UserDetail;


@Component
public class JwtAuthProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private JwtVal validation;
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean supports(Class<?> aClass) {
		return (JwtAuthToken.class.isAssignableFrom(aClass));
	}
	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		JwtAuthToken jwtAuthenticationToken = (JwtAuthToken) authentication;
		String token = jwtAuthenticationToken.getToken();
		UserData user=validation.validate(token);
		if(user==null)
			throw new RuntimeException("token is invalid");
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(user.getRole());
		return new UserDetail(user.getUserId(),token,grantedAuthorities);
	}

}
