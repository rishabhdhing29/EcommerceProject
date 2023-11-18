package com.hexaware.ecommerce.dto;

public class SellerDTO {

	private int sellerId;
	private String sellerName;
	private String sellerPassword;
	private String sellerAddress;
	private String sellerContact;
	private String roles;

	public SellerDTO() {
		super();
	}

	public SellerDTO(int sellerId, String sellerName, String sellerPassword, String sellerAddress,
			String sellerContact) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.sellerPassword = sellerPassword;
		this.sellerAddress = sellerAddress;
		this.sellerContact = sellerContact;
	}

	
	public SellerDTO(int sellerId, String sellerName, String sellerPassword, String sellerAddress, String sellerContact,
			String roles) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.sellerPassword = sellerPassword;
		this.sellerAddress = sellerAddress;
		this.sellerContact = sellerContact;
		this.roles = roles;
	}

	
	
	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerPassword() {
		return sellerPassword;
	}

	public void setSellerPassword(String sellerPassword) {
		this.sellerPassword = sellerPassword;
	}

	public String getSellerAddress() {
		return sellerAddress;
	}

	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}

	public String getSellerContact() {
		return sellerContact;
	}

	public void setSellerContact(String sellerContact) {
		this.sellerContact = sellerContact;
	}
}
