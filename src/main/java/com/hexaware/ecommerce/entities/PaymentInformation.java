package com.hexaware.ecommerce.entities;


/*
Author : Rishabh Dhing
Date   : 15-11-2023
*/
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Payment_Info")
public class PaymentInformation {

	@Id
	private int paymentId;

	@NotNull
	private String cardNumber;

	@NotNull
	private String cvv;

	@NotNull
	private String otp;



	public PaymentInformation() {
		super();
	}



	public PaymentInformation(int paymentId, String cardNumber, String cvv, String otp) {
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
