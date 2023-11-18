package com.hexaware.ecommerce.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class CustomerNotFoundException extends ResponseStatusException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(HttpStatusCode status,String msg) {
		super(status,msg);

	}
}
