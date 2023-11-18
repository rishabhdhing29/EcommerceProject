package com.hexaware.ecommerce.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ecommerce.dto.CartDTO;
import com.hexaware.ecommerce.entities.Cart;
import com.hexaware.ecommerce.service.ICartService;

@RestController
@RequestMapping("/api/cart")
public class CartRestController {

	@Autowired
	private ICartService service;
	
	private static final Logger logger = LoggerFactory.getLogger(CartRestController.class);

	@PostMapping("/add")
	@PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER')")
	public Cart createCart(@RequestBody CartDTO cartDTO) {
		logger.info("Cart created");
		return service.createCart(cartDTO);
	}

	@PutMapping("/update")
	@PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER')")
	public Cart updateCart(@RequestBody CartDTO cartDTO) {
		logger.info("Cart updated");
		return service.updateCart(cartDTO);
	}

	@DeleteMapping("/delete/{cartId}")
	@PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER')")
	public void deleteById(@PathVariable int cartId)
	{
		logger.info("Cart deleted");
		service.deleteCart(cartId);
	}

	@GetMapping("/get/{cartId}")
	@PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER')")
	public CartDTO getAdminById(@PathVariable int cartId) {
		return service.getCartById(cartId);
	}
	@GetMapping("/getall")
	@PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER')")
	public List<Cart> getAllCarts(){
		return service.getAllCarts();
	}
}
