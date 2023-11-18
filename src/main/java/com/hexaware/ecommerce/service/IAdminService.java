package com.hexaware.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.ecommerce.dto.AdminDTO;
import com.hexaware.ecommerce.entities.Admin;
import com.hexaware.ecommerce.entities.Seller;

public interface IAdminService {

	public Admin createAdmin(AdminDTO adminDTO);
	public Admin updateAdmin(AdminDTO adminDTO);
	public void deleteAdmin(int adminId);
	public AdminDTO getAdminById(int adminId );
	public List<Admin> getAllAdmins();
	Optional<Admin> findByadminUserName(String username);
	List<Seller> getSellersForAdmin(int adminId);
	void addSellersToAdmin(int adminId, Seller seller);


}
