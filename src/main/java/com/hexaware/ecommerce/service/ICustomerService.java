package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.dto.CustomerDTO;
import com.hexaware.ecommerce.entities.Customer;

public interface ICustomerService {


	public Customer createCustomer(CustomerDTO customerDTO);
	public Customer updateCustomer(CustomerDTO customerDTO);
	public void deleteCustomer(int customerId);
	public CustomerDTO getCustomerById(int customerId );
	public List<Customer> getAllCustomers();
}
