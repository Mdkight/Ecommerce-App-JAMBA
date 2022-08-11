package com.revature.ecommerce.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
		Customer customer = customerRepository.findById(cart.getCustId()).orElseThrow();
		if(cart.getTotalPrice()>customer.getAccountBalance()) {
			throw new Exception("You do not have enough funds in your account to make that purchase, Please add additional funds");
		}else {
			
			List<Transaction> allTransactionsForCart = transactionRepository.findAllByCartNumber(cart.getCartNumber());
		for (Transaction t : allTransactionsForCart) {
			Movie movie = movieRepository.findById(t.getMovieId()).orElseThrow(() -> new NoResourceFoundException("No movie found for ID: "+ t.getId()));
			movie.setInStock(movie.getInStock() - t.getQuantity());
		}
		customer.setAccountBalance(customer.getAccountBalance()-cart.getTotalPrice());

		return cart;
		}

	}

	@Transactional
	public Cart addOrRemoveItem(Customer customer, Movie movie, int change) {
		Cart currentCart = cartRepository.findByCustIdAndPurchaseDateIsNull(customer.getId()).orElseGet(() -> new Cart(customer));
		if(currentCart==null)
			currentCart=new Cart(customer);
		
		cartRepository.save(currentCart);
		
		List<Transaction> allTransactionsForCart = transactionRepository.findAllByCartNumber(currentCart.getCartNumber());
		boolean success = false;
			
		if(allTransactionsForCart!=null) {
		for(Transaction t:allTransactionsForCart) {
			if (t.getMovieId().equals(movie.getId())) {
				t.setQuantity(t.getQuantity() + change);
				currentCart.setTotalPrice((float) (currentCart.getTotalPrice()+(movie.getPrice()*change)));
				success = true;
		}
			if(t.getQuantity()==0) {
				transactionRepository.delete(t);
			}
			
		}
	}
		if(!success && change>0) {
			
			Transaction newTran=new Transaction(movie, currentCart, change);
			
			transactionRepository.save(newTran);
			
		}
			
		allTransactionsForCart = transactionRepository.findAllByCartNumber(currentCart.getCartNumber());
		cartRepository.save(currentCart);
		currentCart.setTransactions(allTransactionsForCart);

		return currentCart;

	}
	
	@Transactional
	public Cart changeNumInCart(Customer customer, Cart cart, List<Transaction> cartItems) throws NoResourceFoundException {
		Cart currentCart = cartRepository.findByCustIdAndPurchaseDateIsNull(customer.getId())
				.orElse(new Cart(customer));
		currentCart.setTotalPrice(0);
		List<Transaction> persistedInCart = transactionRepository.findAllByCartNumber(cart.getCartNumber());
		
		for(Transaction tran:persistedInCart) 
			transactionRepository.delete(tran);
		
		
		for(Transaction carTran:cartItems) {
			transactionRepository.save(carTran);
			Movie currentMovie = movieRepository.findById(carTran.getMovieId()).orElseThrow(() -> new NoResourceFoundException("No movie found for ID: "+ carTran.getMovieId()));
			currentCart.setTotalPrice((float) (currentCart.getTotalPrice()+(carTran.getQuantity()*currentMovie.getPrice())));
		}
		
		return currentCart;
	}
	
}
