package com.pragmaedge.training.FirstProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pragmaedge.training.FirstProject.Models.User;
import com.pragmaedge.training.FirstProject.exception.BadRequestException;
import com.pragmaedge.training.FirstProject.exception.DataNotFoundException;
import com.pragmaedge.training.FirstProject.services.FirstService;

import java.util.List;

import javax.ws.rs.FormParam;



@RestController
public class FirstController {
    @Autowired
	private FirstService firstService;
    @GetMapping(path="/users")
    public ModelAndView getUsers(){
    	ModelAndView model=new ModelAndView("users");
    	List<User> users=firstService.getUsers();
    	return model.addObject("users", users);
    }
    @GetMapping(path="/allUsers")
    public List<User> getAllUsers()
    {
    	return firstService.getUsers();
    }
    @GetMapping(path="/users/{username}")
    public User getUser(@PathVariable String username) {
    	if(username.equals(""))
    		throw new DataNotFoundException("username is null");
    	else
    	  return firstService.getUser(username);
    }
    @GetMapping(path="/registration")
    public ModelAndView addUser() {
    	return new ModelAndView("registration","user",new User());
    }
	@PostMapping(path="/adduser")
    public ModelAndView addUser(@ModelAttribute User user) {
		if(user.getUsername().equals("")||user.getPassword().equals(""))
			throw new BadRequestException("username / password is null");
		else
		{
    	firstService.postUser(user);
    	return new ModelAndView("search");
		}
    }
	@GetMapping(path="/searchUser")
    public ModelAndView searchUser() {
		return new ModelAndView("search");
    }
	@PostMapping(path="/searchUser")
    public User searchUser(@FormParam("username") String username) {
		if(username.equals(""))
    		throw new BadRequestException("username is null");
		else
		  return firstService.getUser(username);
    }
	@PostMapping(path="/updateUser")
    public User searchUser(@FormParam("username") String username,@FormParam("password") String password)
	{
		if(username.equals("")||password.equals(""))
			throw new BadRequestException("username /password is null");
		else {
		 User user=new User();
		 user.setUsername(username);
		 user.setPassword(password);
	     return firstService.updatUser(user);
		}
    }
	@PutMapping(path="/users/{username}")
    public void updateUser(@RequestBody User user,@PathVariable String username) {
		if(username.equals("")||user==null)
    		throw new DataNotFoundException("username / user is null");
		else {
		user.setUsername(username);
    	firstService.updateUser(user);
		}
    }
	@DeleteMapping(path="/users/{username}")
    public void deleteUser(@PathVariable String username) {
    	firstService.deleteUser(username);
    }
	@PostMapping(path="/deleteUser")
    public void delete(@FormParam("index") int index) {
		List<User> users=firstService.getUsers();
		User user=users.get(index);
    	firstService.deleteUser(user.getUsername());
}
}
