package com.pragmaedge.training.FirstProject;



import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.pragmaedge.training.FirstProject.controllers.UserController;

public class Urlcheck extends FirstProjectApplicationTests {

	private MockMvc mockMVC;
	@InjectMocks
	private UserController userController;
	@Before
	public void setup() throws Exception{
		mockMVC=MockMvcBuilders.standaloneSetup(userController).build();
	}
	 //Test case for getting user using url
		@Test
		public void test_getUserByUrl() throws Exception   {
			mockMVC.perform(MockMvcRequestBuilders.get("/getUser"))
			.andExpect(MockMvcResultMatchers.status().isOk());
		}
		 //Test case for getting user by url
		@Test
		public void test_getUsersByUrl() throws Exception{
			mockMVC.perform(MockMvcRequestBuilders.get("/getAllUsers"))
			.andExpect(MockMvcResultMatchers.status().isOk());
		}
}
