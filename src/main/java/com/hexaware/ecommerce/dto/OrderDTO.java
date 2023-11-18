package com.hexaware.ecommerce.dto;

import java.time.LocalDate;

public class OrderDTO {

	private int orderID;
	private String orderName;
	private int orderAmount;
	private LocalDate orderDate;

	private int paymentId;

	public OrderDTO() {
		super();
	}

	public OrderDTO(int orderID, String orderName, int orderAmount, LocalDate orderDate) {
		super();
		this.orderID = orderID;
		this.orderName = orderName;
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
	}


	public OrderDTO(int orderID, String orderName, int orderAmount, LocalDate orderDate, int paymentId) {
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
