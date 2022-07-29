package com.revature.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int customerId;
	
	@Column(unique=true)
private String username;
private String password;
private String email;

public Customer() {
	super();
}
public Customer(int customerId, String username, String password, String email) {
	super();
	this.customerId = customerId;
	this.username = username;
	this.password = password;
	this.email = email;
}

public Customer(String username, String password, String email) {
	super();
	this.username = username;
	this.password = password;
	this.email = email;
}
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "Customer [customerId=" + customerId + ", username=" + username + ", password=" + password + ", email="
			+ email + "]";
}


}
