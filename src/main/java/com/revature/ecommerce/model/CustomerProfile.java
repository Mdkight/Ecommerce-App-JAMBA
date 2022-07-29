package com.revature.ecommerce.model;



public class CustomerProfile {
	

	private int customerId;//Foreign Key to Customer
	private String firstName;
	private String lastName;
	private float accountBalance;
	private String phoneNumber;
	private String address;
	private String profilePicture; 
	
	public CustomerProfile() {
		super();
	}
	

public CustomerProfile(int customerId, String firstName, String lastName, float accountBalance, String phoneNumber,
			String address, String profilePicture) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountBalance = accountBalance;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.profilePicture = profilePicture;
	}


public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public float getAccountBalance() {
	return accountBalance;
}
public void setAccountBalance(float accountBalance) {
	this.accountBalance = accountBalance;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getProfilePicture() {
	return profilePicture;
}


public void setProfilePicture(String profilePicture) {
	this.profilePicture = profilePicture;
}


@Override
public String toString() {
	return "CustomerProfile [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
			+ ", accountBalance=" + accountBalance + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
}
	
	
	
}
