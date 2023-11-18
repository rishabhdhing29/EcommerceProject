package com.hexaware.ecommerce.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class OrderNotFoundException extends ResponseStatusException{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public OrderNotFoundException(HttpStatusCode status,String msg) {
		super(status,msg);

	}
}
