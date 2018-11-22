package com.pragmaedge.training.FirstProject.controllers;

import javax.ws.rs.FormParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pragmaedge.training.FirstProject.Models.UserData;
import com.pragmaedge.training.FirstProject.security.JwtGen;

@RestController
public class TokenController {

        @Autowired
		private JwtGen generator;

		public TokenController(JwtGen generator) {

			this.generator = generator;
		}

		@PostMapping("/token")
		public String generate(@FormParam("userId") String userId,@FormParam("role") String role) {
            
			UserData user=new UserData();
			user.setUserId(userId);
			user.setRole(role);
			return generator.generate(user);
		}

	
}
