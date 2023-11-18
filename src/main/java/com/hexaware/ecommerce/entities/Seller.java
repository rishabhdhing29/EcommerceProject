package com.hexaware.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Seller_Info")
public class Seller {

	@Id
	private int sellerId;

	@NotBlank
	@Size(min = 2, max = 50)
	private String sellerName;

	@NotBlank
	@Size(min = 6, max = 30)
	private String sellerPassword;

	@NotBlank
	private String sellerAddress;

	@NotBlank
	@Pattern(regexp = "\\d{10}") // Assuming 10 digits for a contact number
	private String sellerContact;

	@NotBlank
	private String roles;

	@ManyToOne
	@JoinColumn(name = "adminId")
	private Admin admin;

	public Seller() {
		super();
	}

	public Seller(int sellerId, String sellerName, String sellerPassword, String sellerAddress, String sellerContact) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.sellerPassword = sellerPassword;
		this.sellerAddress = sellerAddress;
		this.sellerContact = sellerContact;
	}

	public Seller(int sellerId, String sellerName, String sellerPassword, String sellerAddress, String sellerContact,
			String roles) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.sellerPassword = sellerPassword;
		this.sellerAddress = sellerAddress;
		this.sellerContact = sellerContact;
		this.roles = roles;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
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

	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", sellerName=" + sellerName + ", sellerPassword=" + sellerPassword
				+ ", sellerAddress=" + sellerAddress + ", sellerContact=" + sellerContact + "]";
	}

}
