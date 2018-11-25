package com.pragmaedge.training.FirstProject.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.FormParam;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pragmaedge.training.FirstProject.Models.UserData;
import com.pragmaedge.training.FirstProject.services.UserService;

@RestController
public class UserController {
 
	@Autowired
	UserService service;
	@GetMapping(path="/getUser")
	public ModelAndView getUser() {
		ModelAndView model=new ModelAndView("input","user", new UserData());
		return model;
	}
	@PostMapping(path="/postuser")
	public ModelAndView postUser(@Valid @ModelAttribute UserData user) {
		   
			service.postUser(user);
		   ModelAndView model=new ModelAndView("searchUser");
		   List<UserData> users=null;
		try {
			users = service.getUsers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     return model.addObject("users", users);
		
	}
	@GetMapping(path="/getAllUsers")
	public ModelAndView getAllUsers() {
		 List<UserData> users=null;
		 ModelAndView model=null;
		   /*UserData ud=new UserData();
		   UserData ud1=new UserData();
		   ud.setUserId("kavya123");
		   ud1.setUserId("manasa123");*/
		 
		   try {
			  model=new ModelAndView("searchUser");
			users=service.getUsers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     return model.addObject("users",users);
	}
	@PostMapping(path="/searchUsers")
	public ModelAndView searchUsers(@FormParam("userid") String userid,@FormParam("role") String role,@FormParam("firstname") String firstname,@FormParam("lastname") String lastname,@FormParam("value") String status)
	{
		ModelAndView model=null;
		 List<UserData> users=null;
		try
		{
		 model=new ModelAndView("searchUser");
		 
			users = service.searchUser(userid,role,firstname, lastname, status);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model.addObject("users",users);    
		
	}
	@GetMapping(path="/update/{userId}") 
	public ModelAndView updateUser(@PathVariable String userId) {
			UserData user=null;
			ModelAndView model=null;
			try {
			user=service.getUser(userId);
		    model=new ModelAndView("edit");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	        return model.addObject("user", user);
	}
	@PostMapping(path="/updateData")
	public ModelAndView update(@ModelAttribute UserData user) {
		   List<UserData> users=null;
		   ModelAndView model=null;
		   try {
		 service.updateUser(user);
		 users=service.getUsers();
		 model=new ModelAndView("searchUser");
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
		   return model.addObject("users", users);
	}
	@GetMapping(path="/delete/{userId}") 
	public ModelAndView deleteUser(@PathVariable String userId) {
			ModelAndView model=null;
			List<UserData> users=null;
			try {
			service.deleteUser(userId);
		    model=new ModelAndView("searchUser");
		    users = service.getUsers();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	        return model.addObject("users", users);
	}
}
