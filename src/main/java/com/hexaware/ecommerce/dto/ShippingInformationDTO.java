package com.hexaware.ecommerce.dto;

public class ShippingInformationDTO {

	private int shippingId;
	private String firstName;
	private String lastName;
	private String shippingAddress;
	private String shippingCity;
	private String postalCode;

	public ShippingInformationDTO() {
		super();
	}

	public ShippingInformationDTO(int shippingId, String firstName, String lastName, String shippingAddress,
			String shippingCity, String postalCode) {
		super();
		this.shippingId = shippingId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.shippingAddress = shippingAddress;
		this.shippingCity = shippingCity;
		this.postalCode = postalCode;
	}

	public int getShippingId() {
		return shippingId;
	}

	public void setShippingId(int shippingId) {
		this.shippingId = shippingId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
