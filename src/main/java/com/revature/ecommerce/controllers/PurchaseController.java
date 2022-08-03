package com.revature.ecommerce.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/jamba/cart")
public class PurchaseController {

	//TODO if cart exists get current cart, else create a new one 
	
}
