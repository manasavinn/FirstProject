package com.pragmaedge.training.FirstProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pragmaedge.training.FirstProject.Models.UserData;
import com.pragmaedge.training.FirstProject.dao.UserAccess;
@Service
public class UserService {

	@Autowired
	private UserAccess userAccess;
	public void postUser(UserData user)
	{
		userAccess.postUser(user);
	}
	public List<UserData> getUsers()throws Exception
	{
		return userAccess.getUsers();
	}
	public List<UserData> searchUser(String userid,String role,String firstName,String lastName,String status) throws Exception{
		List<UserData> users=userAccess.searchUsers(userid,role,firstName, lastName, status);
		String name=users.get(0).getFirstName();
		System.out.println(name);
		return users;
	}
	public UserData updateUser(UserData user)throws Exception
	{
		return userAccess.updateUser(user);
	}
	public UserData getUser(String userId)throws Exception
	{
		return userAccess.getUser(userId);
	}
	public void deleteUser(String userId)throws Exception
	{
		userAccess.deleteUser(userId);
	}
}
