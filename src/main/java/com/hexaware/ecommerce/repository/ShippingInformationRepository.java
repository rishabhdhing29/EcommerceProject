package com.hexaware.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.ecommerce.entities.ShippingInformation;



@Repository
public interface ShippingInformationRepository extends JpaRepository<ShippingInformation, Integer> {

}
