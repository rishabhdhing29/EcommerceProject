package com.hexaware.ecommerce.dto;


public class ProductDTO {


	private int productId;
	private String productName;
	private int productQuantity;
	private double productAmount;

	public ProductDTO() {
		super();
	}

	public ProductDTO(int productId, String productName, int productQuantity, double productAmount) {
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

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", productQuantity="
				+ productQuantity + ", productAmount=" + productAmount + "]";
	}



}
