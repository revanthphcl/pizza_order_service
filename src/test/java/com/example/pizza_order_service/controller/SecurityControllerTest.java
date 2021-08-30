package com.example.pizza_order_service.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.queryParam;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.pizza_order_service.controllers.SecurityController;
import com.example.pizza_order_service.model.User;
import com.example.pizza_order_service.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
public class SecurityControllerTest {

	private AutoCloseable closeable;
	
	@Mock
	private UserService userService;
	
	@Mock
	private User user;
	
	@InjectMocks
	private SecurityController securityController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		closeable = MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(securityController).build();
		
		user = new User();
		user.setName("John Doe");
		user.setPassword("secret");
	}
	
	@After
	public void tearDown() throws Exception {
		closeable.close();
	}
	
	@Test
	public void testLandingExpectsLandingPage() throws Exception {
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("landing.html"));
		
		mockMvc.perform(get("/landing"))
			.andExpect(status().isOk())
			.andExpect(view().name("landing.html"));
	}
	
	@Test
	public void testLoginExpectsLoginPage() throws Exception {
		//Without a username or password, the controller returns login page
		mockMvc.perform(post("/login"))
		.andExpect(status().isOk())
		.andExpect(view().name("login.html"));
	}
	
	@Test
	public void testLoginExpectsLandingPage() throws Exception {
		when(userService.findUserByUserName("John Doe")).thenReturn(user);
		
		
		mockMvc.perform(get("/login")
				.param("username", "John Doe")
				.param("password", "secret")
			).andDo(print())
		.andExpect(status().isOk())
			.andExpect(view().name("landing.html"));
	}
	
}
