package com.example.pizza_order_service.security;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordConfigTest {

	private PasswordConfig passwordConfig;
	
	@Before
	public void setUp() {
		passwordConfig = new PasswordConfig();
	}
	
	@Test
	public void testPasswordEncoderExpectsBCryptPassword() {
		Object result = passwordConfig.passwordEncoder();
		
		assertEquals(BCryptPasswordEncoder.class, result.getClass());
		
	}
}
