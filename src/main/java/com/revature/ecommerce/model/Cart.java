package com.revature.ecommerce.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","customer"})
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartNumber;//Primary Key	
	
	private LocalDate purchaseDate;
	private float totalPrice;
	
	
	@OneToMany(mappedBy = "cart")
	private List<Transaction> transactions;

	@ManyToOne(optional = false, fetch=FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	public Cart(Customer customer) {
		super();
		this.customer=customer;
		
	}


	


	
	
	
}
