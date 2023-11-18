package com.hexaware.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hexaware.ecommerce.dto.PaymentInformationDTO;
import com.hexaware.ecommerce.entities.PaymentInformation;
import com.hexaware.ecommerce.repository.PaymentInformationRepository;

@Service
public class PaymentInformationServiceImp implements IPaymentInformationService {

	@Autowired
	PaymentInformationRepository paymentRepo;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public PaymentInformation addPaymentInformation(PaymentInformationDTO paymentInformationDTO) {
		PaymentInformation paymentInformation = new PaymentInformation();
		paymentInformation.setPaymentId(paymentInformationDTO.getPaymentId());
		paymentInformation.setCardNumber(paymentInformationDTO.getCardNumber());
		paymentInformation.setCvv(paymentInformationDTO.getCvv());
		paymentInformation.setOtp(paymentInformationDTO.getOtp());
		return paymentRepo.save(paymentInformation);
	}

	@Override
	public PaymentInformation updatePaymentInformation(PaymentInformationDTO paymentInformationDTO) {

		PaymentInformation paymentInformation = paymentRepo.findById(paymentInformationDTO.getPaymentId()).orElse(new PaymentInformation());

		paymentInformation.setPaymentId(paymentInformationDTO.getPaymentId());
		paymentInformation.setCardNumber(paymentInformationDTO.getCardNumber());
		paymentInformation.setCvv(paymentInformationDTO.getCvv());
		paymentInformation.setOtp(paymentInformationDTO.getOtp());
		return paymentRepo.save(paymentInformation);
	}

	@Override
	public void deletePaymentInformation(int paymentId) {

		PaymentInformation paymentInformation =paymentRepo.findById(paymentId).orElse(null);
		paymentRepo.delete(paymentInformation);


	}

	@Override
	public PaymentInformationDTO getBypaymentId(int paymentId) {

		PaymentInformation paymentInformation =paymentRepo.findById(paymentId).orElse(new PaymentInformation() );
		return new PaymentInformationDTO(paymentInformation.getPaymentId(),paymentInformation.getCardNumber(),paymentInformation.getCvv(),paymentInformation.getOtp());
	}

	@Override
	public List<PaymentInformation> getAllPayments() {
		return paymentRepo.findAll(Sort.by("paymentId"));
	}

}
