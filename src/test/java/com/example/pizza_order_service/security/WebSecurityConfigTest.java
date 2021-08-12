package com.example.pizza_order_service.security;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.password.PasswordEncoder;

public class WebSecurityConfigTest {

	private AutoCloseable closeable;
	
	@Mock
	private PasswordEncoder passwordEncoderMock;
	
	@Mock
	private CustomUserDetailsService customUserDetailsServiceMock;
	
	@InjectMocks
	private WebSecurityConfig webSecurityConfig;
	
	@Before
	public void setUp() throws Exception {
		closeable = MockitoAnnotations.openMocks(this);
	}
	
	@After
	public void tearDown() throws Exception {
		closeable.close();
	}
	
	@Test
	public void testDaoAuthenticationProviderExpectsDaoAuthenticationProvider() {
		
		DaoAuthenticationProvider result = webSecurityConfig.daoAuthenticationProvider();
		assertEquals(DaoAuthenticationProvider.class, result.getClass());
	}
}
