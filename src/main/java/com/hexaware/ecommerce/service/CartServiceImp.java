package com.hexaware.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hexaware.ecommerce.dto.CartDTO;
import com.hexaware.ecommerce.entities.Cart;
import com.hexaware.ecommerce.repository.CartRepository;

@Service
public class CartServiceImp implements ICartService {

	@Autowired
	CartRepository cartRepo;

	@Autowired
	RestTemplate restTemplate;


	@Override
	public Cart createCart(CartDTO cartDTO) {
		Cart cart = new Cart();
		cart.setCartId(cartDTO.getCartId());
		cart.setCustomerId(cartDTO.getCustomerId());
		cart.setProductName(cartDTO.getProductName());
		cart.setProductQuantity(cartDTO.getProductQuantity());
		cart.setProductAddedDate(cartDTO.getProductAddedDate());
		return cartRepo.save(cart);
	}

	@Override
	public Cart updateCart(CartDTO cartDTO) {

		Cart cart=cartRepo.findById(cartDTO.getCartId()).orElse(new Cart());
		cart.setCartId(cartDTO.getCartId());
		cart.setCustomerId(cartDTO.getCustomerId());
		cart.setProductName(cartDTO.getProductName());
		cart.setProductQuantity(cartDTO.getProductQuantity());
		cart.setProductAddedDate(cartDTO.getProductAddedDate());
		return cartRepo.save(cart);
	}

	@Override
	public void deleteCart(int cartId) {
		Cart cart = cartRepo.findById(cartId).orElse(null);
		cartRepo.delete(cart);

	}

	@Override
	public CartDTO getCartById(int cartId) {
		Cart cart = cartRepo.findById(cartId).orElse(new Cart());
		return new CartDTO(cart.getCartId(),cart.getCustomerId(),cart.getProductId(),cart.getProductName(),cart.getProductQuantity(),cart.getProductAddedDate());

	}

	@Override
	public List<Cart> getAllCarts() {
		return cartRepo.findAll(Sort.by("cartId"));
	}

	public Cart saveCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartRepo.save(cart);
	}

}
