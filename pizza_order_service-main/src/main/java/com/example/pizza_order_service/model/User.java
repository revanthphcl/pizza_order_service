package com.example.pizza_order_service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private @Id @GeneratedValue Long userId;
	private String name, email, password, address;
	private Long phoneNo;
	private String role;
	
	public User(long id, String name, String email, String address, String password, long phoneNo) {
		this.userId = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.password = password;
		this.phoneNo = phoneNo;	
	}
	
	@Override
	public String toString() {
		return "User{" + 
				"id = " + userId +
				", name = " + name + '\'' +
				", email = " + email + '\'' +
				", phoneNo = " + phoneNo + '\'' +
				'}';
	}
}
