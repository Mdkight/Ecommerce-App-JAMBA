package com.revature.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","carts"})
@Table(name="Customer_HM")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cust_id")
	private Integer id;

	@Column(unique = true)
	private String username;
	
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private float accountBalance;
	private String phoneNumber;
	private String address;
	private String profilePicture; 
	

	public Customer(String username, String password, String email, String firstName, String lastName,
			float accountBalance, String phoneNumber, String address, String profilePicture) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountBalance = accountBalance;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.profilePicture = profilePicture;
	
	}
	
	

}
