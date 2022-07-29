package com.revature.ecommerce.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(unique = true, nullable = false)
	private String username;
	private String password;
	private String email;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Cart> carts = new HashSet<>();
	

	public Customer(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}

}
