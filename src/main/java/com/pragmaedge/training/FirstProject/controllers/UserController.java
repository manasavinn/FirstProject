package com.pragmaedge.training.FirstProject.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pragmaedge.training.FirstProject.Models.UserData;

@RestController
public class UserController {
 
	@GetMapping(path="/getUser")
	public ModelAndView getUser() {
		ModelAndView model=new ModelAndView("input","user", new UserData());
		return model;
	}
	@PostMapping(path="/postuser")
	public ModelAndView postUser(@ModelAttribute UserData user) {
	      List<UserData> users=new ArrayList<UserData>();
	      users.add(user);
	      return new ModelAndView("searchUser","users",users);
		
	}
}
