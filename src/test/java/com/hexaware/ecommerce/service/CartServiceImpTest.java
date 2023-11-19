package com.hexaware.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hexaware.ecommerce.dto.CartDTO;
import com.hexaware.ecommerce.entities.Cart;
import com.hexaware.ecommerce.repository.CartRepository;

class CartServiceImpTest {
	
	@Mock
	private CartRepository cartRepositoryMock;
	
	@Mock
	private PasswordEncoder passwordEncoderMock;

	@MockBean
	private PasswordEncoder passwordEncoder;
	
	
	@InjectMocks
	private CartServiceImp cartService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testCreateCart() {
		
		Cart cart = new Cart();
		cart.setCartId(cart.getCartId());
		 cart.setCustomerId(cart.getCustomerId());
		 cart.setProductId(cart.getProductId());
		 cart.setProductName(cart.getProductName());
		 cart.setProductQuantity(cart.getProductQuantity());
		 cart.setProductAddedDate(cart.getProductAddedDate());

        when(cartRepositoryMock.save(cart)).thenReturn(cart);

        Cart savedCart = cartService.saveCart(cart);

        assertNotNull(savedCart);
        assertEquals(cart.getProductName(), savedCart.getProductName());
			
	}
	
	@Test
	void testDeleteCart() {
		Cart cart = new Cart();
		 cart.setCartId(cart.getCartId());
		 cart.setCustomerId(cart.getCustomerId());
		 cart.setProductId(cart.getProductId());
		 cart.setProductName(cart.getProductName());
		 cart.setProductQuantity(cart.getProductQuantity());
		 cart.setProductAddedDate(cart.getProductAddedDate());
		 
 
        when(cartRepositoryMock.findById(cart.getCartId())).thenReturn(Optional.of(cart));

        // Perform delete operation
        cartService.deleteCart(cart.getCartId());

        // Verify that delete method of repository was called with the correct ID
        verify(cartRepositoryMock, times(1)).delete(cart);
	}

	@Test
	void testGetCartById() {
		Cart cart = new Cart();
		cart.setCartId(cart.getCartId());
		 cart.setCustomerId(cart.getCustomerId());
		 cart.setProductId(cart.getProductId());
		 cart.setProductName(cart.getProductName());
		 cart.setProductQuantity(cart.getProductQuantity());
		 cart.setProductAddedDate(cart.getProductAddedDate());

        when(cartRepositoryMock.findById(cart.getCartId())).thenReturn(Optional.of(cart));

        CartDTO foundCart = cartService.getCartById(cart.getCartId());

        assertNotNull(foundCart);
        assertEquals(cart.getCartId(), foundCart.getCartId());
        assertEquals(cart.getCustomerId(), foundCart.getCustomerId());
	}

}
