package com.revature.ecommerce.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ecommerce.model.Customer;
import com.revature.ecommerce.repository.CustomerRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/jamba")
public class MainController {
	
	CustomerRepository customerRepository;

	@RequestMapping("/main")
	public String showMain() {
		return "main";
	}
	
	@GetMapping("/login")
	public ResponseEntity<Customer> loginAttempt(@RequestParam("username") String username, @RequestParam("password") String password){
		//TODO complete login attempt method here
	}
	
}
