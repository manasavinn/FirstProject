package com.pragmaedge.training.FirstProject;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import com.pragmaedge.training.FirstProject.Models.UserData;
import com.pragmaedge.training.FirstProject.dao.UserAccess;


public class FirstMockitoTest extends FirstProjectApplicationTests {
   //Test case to test search users
	@Test
	public void test_searchUsers() throws Exception   {
		UserAccess service=mock(UserAccess.class);
		UserAccess servic=new UserAccess();
		when(service.searchUsers("ammulu890", "Admin", "Jyothi", "Vinnakota", "Active")).thenReturn(servic.searchUsers("ammulu890", "Admin", "Jyothi", "Vinnakota", "Active"));
		List<UserData> users=null;
		try {
			users=service.searchUsers("ammulu890", "Admin", "Jyothi", "Vinnakota", "Active");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(1, users.size());
	}
	//Test case for getting all the users
	@Test
	public void test_getUsers() throws Exception   {
		UserAccess service=mock(UserAccess.class);
		UserAccess servic=new UserAccess();
		when(service.getUsers()).thenReturn(servic.getUsers());
		List<UserData> users=null;
		try {
			users=service.getUsers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(4, users.size());
	}
	//Test case for getting user by userId
		@Test
		public void test_getUser() throws Exception   {
			UserAccess service=mock(UserAccess.class);
			UserAccess servic=new UserAccess();
			when(service.getUser("kavya123")).thenReturn(servic.getUser("kavya123"));
			UserData user=null;
			try {
				user=service.getUser("kavya123");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertEquals("Kavya",user.getFirstName());
		
		}
}
