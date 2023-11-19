package com.hexaware.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hexaware.ecommerce.dto.PaymentInformationDTO;
import com.hexaware.ecommerce.entities.PaymentInformation;
import com.hexaware.ecommerce.repository.PaymentInformationRepository;

class PaymentInformationServiceImpTest {
	
	@InjectMocks
	private PaymentInformationServiceImp paymentService;
	
	@Mock
	private PaymentInformationRepository paymentRepositoryMock;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAddPaymentInformation() {
		 PaymentInformation paymentInfo = new PaymentInformation();
		 
		 paymentInfo.setPaymentId(paymentInfo.getPaymentId());
		 paymentInfo.setCardNumber(paymentInfo.getCardNumber());
		 paymentInfo.setCvv(paymentInfo.getCvv());
		 paymentInfo.setOtp(paymentInfo.getOtp());
		 when(paymentRepositoryMock.save(paymentInfo)).thenReturn(paymentInfo);

		 PaymentInformation savedPayment = paymentService.addPaymentInformation(paymentInfo);

	        assertNotNull(savedPayment);
	        assertEquals(paymentInfo.getPaymentId(), savedPayment.getPaymentId());
	        assertEquals(paymentInfo.getCardNumber(), savedPayment.getCardNumber());
	}

	@Test
	void testDeletePaymentInformation() {
		PaymentInformation paymentInfo = new PaymentInformation();
		 
		 paymentInfo.setPaymentId(paymentInfo.getPaymentId());
		 paymentInfo.setCardNumber(paymentInfo.getCardNumber());
		 paymentInfo.setCvv(paymentInfo.getCvv());
		 paymentInfo.setOtp(paymentInfo.getOtp());
		 
		 when(paymentRepositoryMock.findById(paymentInfo.getPaymentId())).thenReturn(Optional.of(paymentInfo));

	        // Perform delete operation
	        paymentService.deletePaymentInformation(paymentInfo.getPaymentId());

	        // Verify that delete method of repository was called with the correct ID
	        verify(paymentRepositoryMock, times(1)).delete(paymentInfo);
	}

	@Test
	void testGetBypaymentId() {
		PaymentInformation paymentInfo = new PaymentInformation();
		 
		 paymentInfo.setPaymentId(paymentInfo.getPaymentId());
		 paymentInfo.setCardNumber(paymentInfo.getCardNumber());
		 paymentInfo.setCvv(paymentInfo.getCvv());
		 paymentInfo.setOtp(paymentInfo.getOtp());
		 
		 when(paymentRepositoryMock.findById(paymentInfo.getPaymentId())).thenReturn(Optional.of(paymentInfo));

	        PaymentInformationDTO foundPayment = paymentService.getBypaymentId(paymentInfo.getPaymentId());

	        assertNotNull(foundPayment);
	        assertEquals(paymentInfo.getPaymentId(), foundPayment.getPaymentId());
	        assertEquals(paymentInfo.getCardNumber(), foundPayment.getCardNumber());
	}



}
