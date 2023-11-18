package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.dto.ProductDTO;
import com.hexaware.ecommerce.entities.Product;

public interface IProductService {

	public Product addProduct(ProductDTO productDTO);
	public Product updateProduct(ProductDTO productDTO);
	public void deleteProduct(int productId);
	public ProductDTO getByproductId(int productId);
	public List<Product> getAllProducts();
}
