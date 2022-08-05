package com.revature.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InsufficientFundsException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public InsufficientFundsException(String message) {
		super(message);
	}

}
