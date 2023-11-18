package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.dto.CartDTO;
import com.hexaware.ecommerce.entities.Cart;


public interface ICartService {

	public Cart createCart(CartDTO cartDTO);
	public Cart updateCart(CartDTO cartDTO);
	public void deleteCart(int cartId);
	public CartDTO getCartById(int cartId );
	public List<Cart> getAllCarts();
}
