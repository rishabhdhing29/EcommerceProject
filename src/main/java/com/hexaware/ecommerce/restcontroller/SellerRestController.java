package com.hexaware.ecommerce.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ecommerce.dto.AuthRequest;
import com.hexaware.ecommerce.dto.SellerDTO;
import com.hexaware.ecommerce.entities.Seller;
import com.hexaware.ecommerce.service.ISellerService;
import com.hexaware.ecommerce.service.JwtService;

@RestController
@RequestMapping("/api/seller")
public class SellerRestController {

	Logger logger = LoggerFactory.getLogger(SellerRestController.class);

	@Autowired
	private ISellerService service;
	
	@Autowired
	private JwtService jwtService;

	@Autowired
	AuthenticationManager authenticationManager;

	@PostMapping("/add")
	public Seller createSeller(@RequestBody SellerDTO sellerDTO) {
		logger.info("Seller added successfully");
		return service.createSeller(sellerDTO);
	}

	@PutMapping("/update")
	@PreAuthorize("hasAnyAuthority('ROLE_SELLER')")
	public Seller updateSeller(@RequestBody SellerDTO sellerDTO) {
		logger.info("Seller updated successfully");
		return service.updateSeller(sellerDTO);
	}

	@DeleteMapping("/delete/{sellerId}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_SELLER')")
	public void deleteById(@PathVariable int sellerId)
	{
		logger.info("Seller deleted successfully");
		service.deleteSeller(sellerId);
	}

	@GetMapping("/get/{sellerId}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_SELLER')")
	public SellerDTO getAdminById(@PathVariable int sellerId) {
		return service.getSellerById(sellerId);
	}
	@GetMapping("/getall")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_SELLER')")
	public List<Seller> getAllSellers(){
		return service.getAllSellers();
	}
	
	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {

		Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

		String token = null;

		if (authenticate.isAuthenticated()) {

			token = jwtService.generateToken(authRequest.getUsername());

		}

		else {

			throw  new UsernameNotFoundException("Invalid Username or Password / Invalid request");
		}

		return token;
	}
}
