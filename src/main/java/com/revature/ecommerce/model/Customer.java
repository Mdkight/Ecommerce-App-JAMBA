package com.revature.ecommerce.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cust_id")
	private Integer id;

	@Column(unique = true, nullable = false)
	private String username;
	@Column(name = "cust_pwd")
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private float accountBalance;
	private String phoneNumber;
	private String address;
	private String profilePicture; 
	
	@OneToMany(mappedBy = "customer")
	private Set<Cart> carts = new HashSet<>();

	public Customer(String username, String password, String email, String firstName, String lastName,
			float accountBalance, String phoneNumber, String address, String profilePicture, Set<Cart> carts) {
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
		this.carts = carts;
	}
	
	

}
