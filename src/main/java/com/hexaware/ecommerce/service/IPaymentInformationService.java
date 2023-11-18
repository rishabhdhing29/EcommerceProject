package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.dto.PaymentInformationDTO;
import com.hexaware.ecommerce.entities.PaymentInformation;

public interface IPaymentInformationService {


	public PaymentInformation addPaymentInformation(PaymentInformationDTO paymentInformationDTO);
	public PaymentInformation updatePaymentInformation(PaymentInformationDTO paymentInformationDTO);
	public void deletePaymentInformation(int paymentId);
	public PaymentInformationDTO getBypaymentId(int paymentId);
	public List<PaymentInformation> getAllPayments();
}
