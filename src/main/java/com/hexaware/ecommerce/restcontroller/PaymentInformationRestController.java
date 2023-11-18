package com.hexaware.ecommerce.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ecommerce.dto.PaymentInformationDTO;
import com.hexaware.ecommerce.entities.PaymentInformation;
import com.hexaware.ecommerce.exception.PaymentNotFoundException;
import com.hexaware.ecommerce.service.IPaymentInformationService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;



@RestController
@RequestMapping("/api/paymentinfo")
public class PaymentInformationRestController {

	@Autowired
	private IPaymentInformationService service;
	
	private static final Logger logger = LoggerFactory.getLogger(PaymentInformationRestController.class);

	@PostMapping("/add")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public PaymentInformation addPaymentInformation(@RequestBody PaymentInformationDTO paymentInformationDTO) {
		logger.info("Payment Info added");
		return service.addPaymentInformation(paymentInformationDTO);
	}

	@PutMapping("/update")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public PaymentInformation updatePaymentInformation(@RequestBody PaymentInformationDTO paymentInformationDTO) {
		logger.info("Payment Info updated");
		return service.updatePaymentInformation(paymentInformationDTO);
	}

	@DeleteMapping("/delete/{paymentId}")
	@PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER','ROLE_ADMIN')")
	public void deleteById(@PathVariable int paymentId) {
		logger.info("Payment Info deleted");
		service.deletePaymentInformation(paymentId);
	}

	@GetMapping("/get/{paymentId}")
	@PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER','ROLE_ADMIN','ROLE_SELLER')")
	public PaymentInformationDTO getBypaymentId(@PathVariable @Valid @Min(1) int paymentId) throws PaymentNotFoundException {
		if(paymentId==0) {
			throw new PaymentNotFoundException(HttpStatus.BAD_REQUEST,"payment not found"+paymentId);
		}
		logger.info("Payment Info found");
		return service.getBypaymentId(paymentId);
	}

	@GetMapping("/getall")
	@PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER','ROLE_ADMIN')")
	public List<PaymentInformation> getAllPayments() {
		return service.getAllPayments();
	}
}
