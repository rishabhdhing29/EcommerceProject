package com.hexaware.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.ecommerce.entities.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Optional<Admin> findByadminUserName(String adminName);

}
