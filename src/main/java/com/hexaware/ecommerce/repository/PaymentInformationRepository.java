package com.hexaware.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.ecommerce.entities.PaymentInformation;



@Repository
public interface PaymentInformationRepository extends JpaRepository<PaymentInformation, Integer> {

}
