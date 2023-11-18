package com.hexaware.ecommerce.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "Order_Details")
public class Order {

	@Id
	private int orderID;

	@NotBlank
	private String orderName;

	@NotBlank
	private int orderAmount;
	private LocalDate orderDate;
    
	@NotNull
	private int paymentId;

	public Order() {
		super();
	}

	public Order(int orderID, String orderName, int orderAmount, LocalDate orderDate) {
		super();
		this.orderID = orderID;
		this.orderName = orderName;
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
	}


	public Order(int orderID, String orderName, int orderAmount, LocalDate orderDate, int paymentId) {
		super();
		this.orderID = orderID;
		this.orderName = orderName;
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
		this.paymentId = paymentId;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

}
