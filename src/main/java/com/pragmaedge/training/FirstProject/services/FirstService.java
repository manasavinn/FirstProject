package com.pragmaedge.training.FirstProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pragmaedge.training.FirstProject.Models.User;
import com.pragmaedge.training.FirstProject.dao.FirstDataAccess;

@Service
public class FirstService {
	@Autowired
	FirstDataAccess data;

	public List<User> getUsers()
	{
		return data.getUsers();
	}
	public User checkUser(String username, String password) {
			return data.checkUser(username,password);
	  
	      
	
  }
	public User getUser(String username)
	{
		return data.getUser(username);
	}
	public User updatUser(User user)
	{
		return data.updatUser(user);
	}
	public void postUser(User user)
	{
		data.postUser(user);
	}
	public void deleteUser(String username)
	{
		data.deleteUser(username);
	}
	public void updateUser(User user)
	{
		data.updateUser(user);
	}
}
