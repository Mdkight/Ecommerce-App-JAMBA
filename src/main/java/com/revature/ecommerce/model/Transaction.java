package com.revature.ecommerce.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","movie", "cart"})
public class Transaction {
	
	@EmbeddedId
	private TransactionId id;
	
	
	@ManyToOne
	@MapsId("movieId")
	@JoinColumn(name = "movie_id")
	private Movie movie;
	
	
	@ManyToOne
	@MapsId("cartNumber")
	@JoinColumn(name = "cart_number")
	private Cart cart;
	
	private Integer quantity;

	public Transaction(Movie movie, Cart cart, Integer quantity) {
		super();
		this.id = new TransactionId(movie.getId(), cart.getCartNumber());
		this.quantity = quantity;
	}	
	
	

	

}
