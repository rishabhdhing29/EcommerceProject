package com.hexaware.ecommerce.dto;


public class AdminDTO {

	private int AdminId;
	private String adminName;
	private String adminUserName;
	private String adminPassword;
	private String adminContact;
	private String adminEmail;
	private String roles;

	public AdminDTO() {
		super();
	}

	public AdminDTO(int adminId, String adminName, String adminUserName, String adminPassword, String adminContact,
			String adminEmail) {
		super();
		AdminId = adminId;
		this.adminName = adminName;
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
		this.adminContact = adminContact;
		this.adminEmail = adminEmail;
	}

	
	public AdminDTO(int adminId, String adminName, String adminUserName, String adminPassword, String adminContact,
			String adminEmail, String roles) {
		super();
		AdminId = adminId;
		this.adminName = adminName;
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
		this.adminContact = adminContact;
		this.adminEmail = adminEmail;
		this.roles = roles;
	}

	public int getAdminId() {
		return AdminId;
	}

	public void setAdminId(int adminId) {
		AdminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

}
