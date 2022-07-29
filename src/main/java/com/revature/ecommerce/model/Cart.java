package com.revature.ecommerce.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartNumber;//Primary Key
	
	@JoinColumn
	private int movieId;//foreign Key to Movie
	private int quantity;
	private float totalPrice;
	
	
	public Cart() {
		super();
	}
	public Cart(int cartNumber, int movieId, int quantity, float totalPrice) {
		super();
		this.cartNumber = cartNumber;
		this.movieId = movieId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	public int getCartNumber() {
		return cartNumber;
	}
	public void setCartNumber(int cartNumber) {
		this.cartNumber = cartNumber;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Cart [cartNumber=" + cartNumber + ", movieId=" + movieId + ", quantity=" + quantity + ", totalPrice="
				+ totalPrice + "]";
	}
	
	

	
}
