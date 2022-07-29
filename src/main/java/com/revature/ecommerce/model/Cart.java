package com.revature.ecommerce.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartNumber;//Primary Key	
	
	private Integer customerId;//Foreign Key to Customer
	
	private LocalDate purchaseDate;
	private float totalPrice;
	
	@OneToMany(mappedBy = "cart")
	private Set<Transaction> transactions = new HashSet<>();

	public Cart(Integer customerId, LocalDate purchaseDate, float totalPrice) {
		super();
		this.customerId = customerId;
		this.purchaseDate = purchaseDate;
		this.totalPrice = totalPrice;
	}

	
	
	
}
