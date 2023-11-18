package com.hexaware.ecommerce.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class PaymentNotFoundException extends ResponseStatusException {

	public PaymentNotFoundException(HttpStatusCode status,String msg) {
		super(status,msg);

	}
}
