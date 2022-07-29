package com.revature.ecommerce.model;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Transaction {

	
	private int customerId;//Foreign Key to Customer
	private int cartNumber;//Foreign Key to Cart
	
	private LocalDate purchaseDate;
	private float totalPrice;
	
	public Transaction() {
		super();
	}

	public Transaction(int customerId, int cartNumber, LocalDate purchaseDate, float totalPrice) {
		super();
		this.customerId = customerId;
		this.cartNumber = cartNumber;
		this.purchaseDate = purchaseDate;
		this.totalPrice = totalPrice;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getCartNumber() {
		return cartNumber;
	}

	public void setCartNumber(int cartNumber) {
		this.cartNumber = cartNumber;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Transactions [customerId=" + customerId + ", cartNumber=" + cartNumber + ", purchaseDate="
				+ purchaseDate + ", totalPrice=" + totalPrice + "]";
	}
	
	
	
}
