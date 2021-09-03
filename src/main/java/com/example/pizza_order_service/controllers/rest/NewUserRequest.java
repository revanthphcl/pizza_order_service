package com.example.pizza_order_service.controllers.rest;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Digits;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class NewUserRequest {
	
	@NotBlank
	@Size(min = 3, max = 30)
	private String name;
	
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	
	@NotBlank
	@Size(min = 6, max = 50)
	private String password;
	
	
	private String address;
	
	@Digits(fraction = 0, integer = 9)
	private Long phoneNo;
	
	private String role;
}
