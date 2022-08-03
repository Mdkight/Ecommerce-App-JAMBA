package com.revature.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.ecommerce.model.Transaction;
import com.revature.ecommerce.model.TransactionId;

public interface TransactionRepository extends JpaRepository<Transaction, TransactionId> {

	public List<Transaction> findAllByTransactionId_CartNumber(Integer cartNumber);
}
