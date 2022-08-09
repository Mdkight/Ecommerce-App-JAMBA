package com.revature.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.ecommerce.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	public Optional<Cart> findByCustomerIdAndPurchaseDateIsNull(Integer id);
}
