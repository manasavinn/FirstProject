package com.pragmaedge.training.FirstProject.controllers;



import javax.ws.rs.FormParam;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pragmaedge.training.FirstProject.Models.User;
import com.pragmaedge.training.FirstProject.services.FirstService;

@RestController
public class LoginController {
	 @Autowired
		private FirstService firstService;
	@GetMapping("/login")
	  public ModelAndView index() {
		  return new ModelAndView("login");
	  }
	@PostMapping(path="/checkUser")
	public ModelAndView checkUser(@FormParam("username") String username,@FormParam("password") String password)
	{
		 User user=firstService.checkUser(username, password);
		 if(user==null)
			 return new ModelAndView("login");
		 else
		   return new ModelAndView("search");
         
		
	}
}
