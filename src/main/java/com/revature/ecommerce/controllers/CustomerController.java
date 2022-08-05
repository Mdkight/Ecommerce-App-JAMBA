package com.revature.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ecommerce.model.Customer;
import com.revature.ecommerce.repository.CustomerRepository;

@RestController
@CrossOrigin(origins ="*")
public class CustomerController {
	@Autowired
	CustomerRepository customerRepository;

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value="id")Integer id) throws Exception {
		Customer customer = customerRepository.findById(id).orElseThrow(()->new Exception());
		return ResponseEntity.ok().body(customer);
	}
	
	@PostMapping("/customer")
	public Customer setCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
	
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value="id") Integer id, @RequestBody Customer customer) throws Exception{
		Customer c = customerRepository.findById(id).orElseThrow(()->new Exception());
		c.setUsername(customer.getUsername());
		c.setPassword(customer.getPassword());
		c.setEmail(customer.getEmail());
		c.setAccountBalance(customer.getAccountBalance());
		c.setAddress(customer.getAddress());
		c.setFirstName(customer.getFirstName());
		c.setLastName(customer.getLastName());
		c.setProfilePicture(customer.getProfilePicture());
		c.setPhoneNumber(customer.getPhoneNumber());
		
		Customer updatedCust = customerRepository.save(c);
		return ResponseEntity.ok().body(updatedCust);
	}
}
