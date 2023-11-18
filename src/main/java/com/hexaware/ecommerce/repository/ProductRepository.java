package com.hexaware.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.ecommerce.dto.ProductDTO;
import com.hexaware.ecommerce.entities.Product;



@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	 ProductDTO findByproductName(String productName);

}
