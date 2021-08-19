package com.example.pizza_order_service.security;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.pizza_order_service.model.User;
import com.example.pizza_order_service.service.UserService;

public class CustomUserDetailsServiceTest {

	private AutoCloseable closeable;
	
	@Mock
	private UserService userServiceMock;
	
	@Mock
	private static User userMock;
	
	@InjectMocks
	private CustomUserDetailsService service;
	
	
	@Before
	public void setUp() throws Exception {
		closeable = MockitoAnnotations.openMocks(this);
		
		userMock = new User();
		userMock.setName("John");
		userMock.setPassword("Doe");
		userMock.setRole("User");
	}
	
	@After
	public void tearDown() throws Exception {
		closeable.close();
	}
	
	@Test
	public void testLoadUserByUserNameExpectsUser() {
		when( userServiceMock.findUserByUserName(ArgumentMatchers.anyString())).thenReturn( userMock );
		
		UserDetails result = service.loadUserByUsername("test");
		
		assertEquals(org.springframework.security.core.userdetails.User.class, result.getClass());
	}
	
	@Test(expected = UsernameNotFoundException.class)
	public void testLoadUserByUserNameExpectsExceptionThrownUsernameNotFound() {
		when( userServiceMock.findUserByUserName(ArgumentMatchers.anyString())).thenReturn( null );
		UserDetails result = service.loadUserByUsername("test");
	}
}
