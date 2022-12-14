package com.revature.ecommerce.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.ecommerce.exception.NoResourceFoundException;
import com.revature.ecommerce.model.Cart;
import com.revature.ecommerce.model.Customer;
import com.revature.ecommerce.model.Movie;
import com.revature.ecommerce.model.Transaction;
import com.revature.ecommerce.repository.CartRepository;
import com.revature.ecommerce.repository.CustomerRepository;
import com.revature.ecommerce.repository.MovieRepository;
import com.revature.ecommerce.repository.TransactionRepository;

@Service
public class PurchaseService {
	
	CartRepository cartRepository;
	MovieRepository movieRepository;
	TransactionRepository transactionRepository;
	CustomerRepository customerRepository;
	
	@Autowired
	public PurchaseService(CartRepository cartRepository, MovieRepository movieRepository,
			TransactionRepository transactionRepository, CustomerRepository customerRepository) {
		super();
		this.cartRepository = cartRepository;
		this.movieRepository = movieRepository;
		this.transactionRepository = transactionRepository;
		this.customerRepository = customerRepository;
	}

	@Transactional
	public Cart processCheckout(Cart cart) throws Exception {
		cart.setPurchaseDate(LocalDate.now());
		cartRepository.save(cart);
		Customer customer = customerRepository.findById(cart.getCustomer().getId()).orElseThrow();
		if(cart.getTotalPrice()>customer.getAccountBalance()) {
			throw new Exception("You do not have enough funds in your account to make that purchase, Please add additional funds");
		}else {
		List<Transaction> allTransactionsForCart = transactionRepository
				.findAllById_CartNumber(cart.getCartNumber());
		for (Transaction t : allTransactionsForCart) {
			Movie movie = movieRepository.findById(t.getId().getMovieId()).orElseThrow(() -> new NoResourceFoundException("No movie found for ID: "+ t.getId()));
			movie.setInStock(movie.getInStock() - t.getQuantity());
		}
		customer.setAccountBalance(customer.getAccountBalance()-cart.getTotalPrice());

		return cart;
		}

	}

	@Transactional
	public Cart addOrRemoveItem(Customer customer, Movie movie, int change) {
		Cart currentCart = cartRepository.findByCustomerIdAndPurchaseDateIsNull(customer.getId())
				.orElse(new Cart(customer));
		
		List<Transaction> allTransactionsForCart = transactionRepository
				.findAllById_CartNumber(currentCart.getCartNumber());
		boolean success = false;

		for(Transaction t:allTransactionsForCart) {
			if (t.getId().getMovieId().equals(movie.getId())) {
				t.setQuantity(t.getQuantity() + change);
				currentCart.setTotalPrice((float) (currentCart.getTotalPrice()+(movie.getPrice()*change)));
				success = true;
		}
			if(t.getQuantity()==0) {
				transactionRepository.delete(t);
			}
			
		}
		if(!success && change>0) {
			new Transaction(movie, currentCart, change);
		}
			

		return currentCart;

	}
}
