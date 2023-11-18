package com.hexaware.ecommerce.dto;

public class PaymentInformationDTO {

	private int paymentId;
	private String cardNumber;
	private String cvv;
	private String otp;

	public PaymentInformationDTO() {
		super();
	}

	public PaymentInformationDTO(int paymentId, String cardNumber, String cvv, String otp) {
		super();
		this.paymentId = paymentId;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.otp = otp;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}
}
