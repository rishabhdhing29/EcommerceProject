package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.dto.SellerDTO;
import com.hexaware.ecommerce.entities.Seller;

public interface ISellerService {


	public Seller createSeller(SellerDTO sellerDTO);
	public Seller updateSeller(SellerDTO sellerDTO);
	public void deleteSeller(int sellerId);
	public SellerDTO getSellerById(int sellerId );
	public List<Seller> getAllSellers();
}
