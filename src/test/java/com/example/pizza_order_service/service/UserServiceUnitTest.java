package com.example.pizza_order_service.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.pizza_order_service.model.User;
import com.example.pizza_order_service.repository.UserRepository;



@SpringBootTest
public class UserServiceUnitTest {
	
	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepo;
	
	
	private User createTestUser() {
		User testUser = new User();
		testUser.setUserId((long) 123);
		testUser.setName("TestName");
		testUser.setEmail("TestName@Gmail.com");
		testUser.setPassword("qwerty");
		testUser.setAddress("12345 Fake Street, Nowhere,Kansas 00000");
		testUser.setPhoneNo((long) 1234567890);
		testUser.setRole("customer");
		
		return testUser;
	}
	
	@Test
	public void testSave() {
		User testUser = createTestUser();
		
		userService.save(testUser);
		
		verify(userRepo, times(1)).save(testUser);
	}
	
	@Test
	public void testFindUserByUserName() {
		
		when(userRepo.getUserByName("TestName")).thenReturn(createTestUser());
		
		User retrievedTestUser = userService.findUserByUserName("TestName");
		
		assertEquals("TestName", retrievedTestUser.getName());
		assertEquals("TestName@Gmail.com", retrievedTestUser.getEmail());
		assertEquals((long) 1234567890, retrievedTestUser.getPhoneNo());
	}
	
	@Test
	public void testUserExists() {
		
		User testUser = createTestUser();
		
		boolean foud = userService.userExists(testUser);
		
		verify(userRepo, times(1)).findById(testUser.getUserId());
		
	}
	
	
}