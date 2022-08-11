package com.revature.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.revature.ecommerce.exception.NoResourceFoundException;
import com.revature.ecommerce.model.Cart;
import com.revature.ecommerce.model.Customer;
import com.revature.ecommerce.model.Movie;
import com.revature.ecommerce.model.Transaction;
import com.revature.ecommerce.repository.CartRepository;
import com.revature.ecommerce.repository.CustomerRepository;
import com.revature.ecommerce.repository.MovieRepository;
import com.revature.ecommerce.repository.TransactionRepository;
import com.revature.ecommerce.service.PurchaseService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/jamba")
@EnableWebMvc
public class PurchaseController {

	CartRepository cartRepository;
	MovieRepository movieRepository;
	TransactionRepository transactionRepository;
	CustomerRepository customerRepository;
	PurchaseService purchaseService;
	

	
	@Autowired
	public PurchaseController(CartRepository cartRepository, MovieRepository movieRepository,
			TransactionRepository transactionRepository, CustomerRepository customerRepository, PurchaseService purchaseService) {
		super();
		this.cartRepository = cartRepository;
		this.movieRepository = movieRepository;
		this.transactionRepository = transactionRepository;
		this.customerRepository = customerRepository;
		this.purchaseService = purchaseService;
	}

	@RequestMapping("/cart")
	public ResponseEntity<Cart> getCurrentCart(@RequestBody Customer customer) {
		Cart currentCart = cartRepository.findByCustomerIdAndPurchaseDateIsNull(customer.getId())
				.orElse(new Cart(customer));
		cartRepository.save(currentCart);
		List<Transaction> persistedInCart = transactionRepository
				.findAllById_CartNumber(currentCart.getCartNumber());
		currentCart.setTransactions(persistedInCart);
		return ResponseEntity.ok(currentCart);

	}
	
	@RequestMapping("/updateCart")
	public ResponseEntity<Cart> updateCart(@RequestBody Cart cart) throws NoResourceFoundException{
		Customer customer = customerRepository.findById(cart.getCustomer().getId()).orElseThrow(() -> new NoResourceFoundException("No Customer Found"));
		List<Transaction> cartTransact = cart.getTransactions();
		purchaseService.changeNumInCart(customer, cart, cartTransact);
		return ResponseEntity.ok(cart);
	}

	@RequestMapping("/checkout")
	public ResponseEntity<Cart> checkoutWithCart(@RequestBody Cart cart, @RequestBody List<Transaction> cartTransact, @RequestBody Customer customer) throws Exception {
		
		purchaseService.changeNumInCart(customer, cart, cartTransact);
		purchaseService.processCheckout(cart);

		return ResponseEntity.ok(cart);

	}

	@PostMapping("/movie/{title}/addtocart")
	public ResponseEntity<Cart> addMovieToCart(@PathVariable(value = "title") String movieTitle,
			@RequestBody Customer customer) throws NoResourceFoundException {
		Movie movie = movieRepository.findByTitleContainingIgnoreCase(movieTitle).orElseThrow(() -> new NoResourceFoundException("No Movie by that Title Found"));
		return ResponseEntity.ok(purchaseService.addOrRemoveItem(customer, movie, 1));
	}

	@PostMapping("/movie/{title}/removefromcart")
	public ResponseEntity<Cart> removeMovieFromCart(@PathVariable(value = "title") String movieTitle,
			@RequestBody Customer customer) throws NoResourceFoundException {
		Movie movie = movieRepository.findByTitleContainingIgnoreCase(movieTitle).orElseThrow(() -> new NoResourceFoundException("No Movie by that Title Found"));
		return ResponseEntity.ok(purchaseService.addOrRemoveItem(customer, movie, -1));
	}

}
