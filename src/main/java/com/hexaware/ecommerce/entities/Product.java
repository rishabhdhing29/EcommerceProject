package com.hexaware.ecommerce.entities;

/*
Author : Rishabh Dhing
Date   : 15-11-2023

*/

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Product_Info")
public class Product {

	@Id
	private int productId;

	@NotNull
	private String productName;

	@NotNull
	private int productQuantity;

	@NotNull
	private double productAmount;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "productId")
	private Customer customer;

	public Product() {
		super();
	}

	public Product(int productId, String productName, int productQuantity, double productAmount) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productAmount = productAmount;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(double productAmount) {
		this.productAmount = productAmount;
	}



	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productQuantity="
				+ productQuantity + ", productAmount=" + productAmount + "]";
	}




}
