package com.revature.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.ecommerce.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}