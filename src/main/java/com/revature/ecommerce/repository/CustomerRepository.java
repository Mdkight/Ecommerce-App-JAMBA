package com.revature.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.ecommerce.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	public Customer findByUsername(String username);
	
}

