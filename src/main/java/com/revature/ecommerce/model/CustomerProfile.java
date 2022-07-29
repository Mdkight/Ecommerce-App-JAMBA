package com.revature.ecommerce.model;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Component
public class CustomerProfile {

	@Id
	private Integer customerId;//Foreign Key to Customer
	
	private String firstName;
	private String lastName;
	private float accountBalance;
	private String phoneNumber;
	private String address;
	private String profilePicture; 

	@OneToOne(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Customer customer;

public CustomerProfile(Customer customer, String firstName, String lastName, float accountBalance, String phoneNumber,
			String address, String profilePicture) {
		super();
		this.customerId = customer.getCustomerId();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountBalance = accountBalance;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.profilePicture = profilePicture;
	}
	
	
	
}
