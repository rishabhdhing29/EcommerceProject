package com.hexaware.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hexaware.ecommerce.dto.SellerDTO;
import com.hexaware.ecommerce.entities.Seller;
import com.hexaware.ecommerce.repository.SellerRepository;

@Service
public class SellerServiceImp implements ISellerService {

	@Autowired
	SellerRepository sellerRepo;

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Seller createSeller(SellerDTO sellerDTO) {
		// TODO Auto-generated method stub
		Seller seller = new Seller();
		seller.setSellerId(sellerDTO.getSellerId());
	    seller.setSellerName(sellerDTO.getSellerName());
	    seller.setSellerPassword(passwordEncoder.encode(sellerDTO.getSellerPassword()));
	    seller.setSellerAddress(sellerDTO.getSellerAddress());
	    seller.setSellerContact(sellerDTO.getSellerContact());
	    return sellerRepo.save(seller);
	}

	@Override
	public Seller updateSeller(SellerDTO sellerDTO) {

		Seller seller = sellerRepo.findById(sellerDTO.getSellerId()).orElse(new Seller());
		seller.setSellerName(seller.getSellerName());
	    seller.setSellerPassword(seller.getSellerPassword());
	    seller.setSellerAddress(sellerDTO.getSellerAddress());
	    seller.setSellerContact(sellerDTO.getSellerContact());
	    return sellerRepo.save(seller);
	}

	@Override
	public void deleteSeller(int sellerId) {
		Seller seller= sellerRepo.findById(sellerId).orElse(null);
		sellerRepo.delete(seller);

	}

	@Override
	public SellerDTO getSellerById(int sellerId) {
        Seller seller = sellerRepo.findById(sellerId).orElse(new Seller());
        return new SellerDTO(seller.getSellerId(),seller.getSellerName(),seller.getSellerPassword(),seller.getSellerAddress(),seller.getSellerContact());

	}

	@Override
	public List<Seller> getAllSellers() {
		return sellerRepo.findAll(Sort.by("sellerName"));
	}
	

}
