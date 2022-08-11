package com.revature.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Component
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cart"})
@Table(name="Transaction_HM")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer movieId;
	@Transient
	private Movie movie;
	private Integer cartNumber;
	
	private Integer quantity;

	public Transaction(Movie movie, Cart cart, Integer quantity) {
		super();
		this.cartNumber=cart.getCartNumber();
		this.movieId=movie.getId();
		this.quantity = quantity;
		this.movie=movie;
	}	
	
	

	

}
