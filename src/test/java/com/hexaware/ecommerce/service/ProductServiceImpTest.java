package com.hexaware.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hexaware.ecommerce.dto.CartDTO;
import com.hexaware.ecommerce.dto.ProductDTO;
import com.hexaware.ecommerce.entities.Product;
import com.hexaware.ecommerce.repository.ProductRepository;



class ProductServiceImpTest {

	@Mock
	private ProductRepository productRepositoryMock;
	
	@InjectMocks
	private ProductServiceImp productService;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testAddProduct() {
		Product product = new Product();
        product.setProductId(product.getProductId());
        product.setProductName(product.getProductName());
        product.setProductQuantity(product.getProductQuantity());
        product.setProductAmount(product.getProductAmount());

        when(productRepositoryMock.save(product)).thenReturn(product);

        Product savedProduct = productService.addProduct(product);

        assertNotNull(savedProduct);
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
	}

	@Test
	void testDeleteProduct() {
		Product product = new Product();
        product.setProductId(product.getProductId());
        product.setProductName(product.getProductName());
        product.setProductQuantity(product.getProductQuantity());
        product.setProductAmount(product.getProductAmount());
        
        when(productRepositoryMock.findById(product.getProductId())).thenReturn(Optional.of(product));

        // Perform delete operation
        productService.deleteProduct(product.getProductId());

        // Verify that delete method of repository was called with the correct ID
        verify(productRepositoryMock, times(1)).delete(product);
	}

	@Test
	void testGetByproductId() {
		Product product = new Product();
        product.setProductId(product.getProductId());
        product.setProductName(product.getProductName());
        product.setProductQuantity(product.getProductQuantity());
        product.setProductAmount(product.getProductAmount());
        
        ProductDTO foundProduct = productService.getByproductId(product.getProductId());

        assertNotNull(foundProduct);
        assertEquals(product.getProductId(), foundProduct.getProductId());
	}

}
