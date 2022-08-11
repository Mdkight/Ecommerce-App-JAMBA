package com.revature.ecommerce.repository;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.ecommerce.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	
	public List<Transaction> findAllByCartNumber(Integer cartNumber);

}
