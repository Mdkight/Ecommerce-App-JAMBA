package com.revature.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.ecommerce.model.CustomerProfile;

@Repository
public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, Integer>{
	
}