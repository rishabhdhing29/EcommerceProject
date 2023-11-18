package com.hexaware.ecommerce.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Admin_Info")
public class Admin {

	@Id
	@NotNull
	private int AdminId;

	@NotNull
	private String adminName;

	@NotNull
	private String adminUserName;

	@NotNull
	private String adminPassword;

	@NotNull
	private String adminContact;
	@Email
	private String adminEmail;

	private String roles;
	
	@OneToMany(mappedBy = "admin")
	private List<Seller> seller;

	public Admin() {
		super();
	}

	public Admin(int adminId, String adminName, String adminUserName, String adminPassword, String adminContact,
			String adminEmail) {
		super();
		AdminId = adminId;
		this.adminName = adminName;
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
		this.adminContact = adminContact;
		this.adminEmail = adminEmail;
	}


	public Admin(@NotNull int adminId, @NotNull String adminName, @NotNull String adminUserName,
			@NotNull String adminPassword, @NotNull String adminContact, @Email String adminEmail, String roles) {
		super();
		AdminId = adminId;
		this.adminName = adminName;
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
		this.adminContact = adminContact;
		this.adminEmail = adminEmail;
		this.roles = roles;
	}

	
	public List<Seller> getSeller() {
		return seller;
	}

	public void setSeller(List<Seller> seller) {
		this.seller = seller;
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
