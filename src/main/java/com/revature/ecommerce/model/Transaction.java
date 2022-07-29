package com.revature.ecommerce.model;

import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Getter
@Setter
@ToString
@Component
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
		this.movie = movie;
		this.cart = cart;
		this.quantity = quantity;
	}	
	
	

	

}
