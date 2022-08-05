package com.revature.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Component
public class CustomerProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer profileId;

	
	private String firstName;
	private String lastName;
	private float accountBalance;
	private String phoneNumber;
	private String address;
	private String profilePicture; 

	@OneToOne(optional = false)
	@JoinColumn(name = "customer_id")
	private Customer customer;

public CustomerProfile(Customer customer, String firstName, String lastName, float accountBalance, String phoneNumber,
			String address, String profilePicture) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountBalance = accountBalance;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.profilePicture = profilePicture;
	}
	
	
	
}
