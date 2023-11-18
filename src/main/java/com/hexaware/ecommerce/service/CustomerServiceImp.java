package com.hexaware.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hexaware.ecommerce.dto.CustomerDTO;
import com.hexaware.ecommerce.entities.Customer;
import com.hexaware.ecommerce.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements ICustomerService {

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public Customer createCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setCustomerFirstName(customerDTO.getCustomerFirstName());
		customer.setCustomerLastName(customerDTO.getCustomerLastName());
		customer.setCustomerAddress(customerDTO.getCustomerAddress());
		customer.setCustomerPhoneNumber(customerDTO.getCustomerPhoneNumber());
		customer.setCustomerEmail(customerDTO.getCustomerEmail());
		return customerRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(CustomerDTO customerDTO) {
		Customer customer = customerRepo.findById(customerDTO.getCustomerId()).orElse(new Customer());
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setCustomerFirstName(customerDTO.getCustomerFirstName());
		customer.setCustomerLastName(customerDTO.getCustomerLastName());
		customer.setCustomerAddress(customerDTO.getCustomerAddress());
		customer.setCustomerPhoneNumber(customerDTO.getCustomerPhoneNumber());
		customer.setCustomerEmail(customerDTO.getCustomerEmail());
		return customerRepo.save(customer);
	}

	@Override

	public void deleteCustomer(int customerId) {
		Customer customer = customerRepo.findById(customerId).orElse(null);
		customerRepo.delete(customer);

	}

	@Override
	public CustomerDTO getCustomerById(int customerId) {
		Customer customer = customerRepo.findById(customerId).orElse(new Customer());
		return new CustomerDTO(customer.getCustomerId(), customer.getCustomerFirstName(),
				customer.getCustomerLastName(), customer.getCustomerAddress(), customer.getCustomerPhoneNumber(),
				customer.getCustomerEmail());
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll(Sort.by("customerFirstName"));
	}

}
