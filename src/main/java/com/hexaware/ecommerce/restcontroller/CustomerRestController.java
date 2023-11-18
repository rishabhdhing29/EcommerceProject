package com.hexaware.ecommerce.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ecommerce.dto.AuthRequest;
import com.hexaware.ecommerce.dto.CustomerDTO;
import com.hexaware.ecommerce.entities.Customer;
import com.hexaware.ecommerce.exception.CustomerNotFoundException;
import com.hexaware.ecommerce.service.ICustomerService;
import com.hexaware.ecommerce.service.JwtService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;


@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

	@Autowired
	private ICustomerService service;
	
	@Autowired
	private JwtService jwtService;

	@Autowired
	AuthenticationManager authenticationManager;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerRestController.class);

	@PostMapping("/add")
	public Customer createCustomer(@RequestBody CustomerDTO customerDTO) {
		logger.info("Customer created");
		return service.createCustomer(customerDTO);
	}

	@PutMapping("/update")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public Customer updateCustomer(@RequestBody CustomerDTO customerDTO) {
		logger.info("Customer updated");
		return service.updateCustomer(customerDTO);
	}

	@DeleteMapping("/delete/{customerId}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public void deleteById(@PathVariable int customerId)
	{
		logger.info("Customer deleted");
		service.deleteCustomer(customerId);
	}


	 @GetMapping("/get/{customerId}")
	 @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_SELLER')")
	 public CustomerDTO getCustomerById(@PathVariable @Valid  @Min(1) int customerId) throws CustomerNotFoundException{

		 if(customerId==0) {
				throw new CustomerNotFoundException(HttpStatus.BAD_REQUEST,"customer not found"+customerId);
			}
		 return service.getCustomerById(customerId);
		 }

	@GetMapping("/getall")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_SELLER')")
	public List<Customer> getAllCustomers(){
		return service.getAllCustomers();
	}
	
	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {

		Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

		String token = null;
		
		if (authenticate.isAuthenticated()) {

			token = jwtService.generateToken(authRequest.getUsername());
			
		}

		else {
			
			throw  new UsernameNotFoundException("Invalid Username or Password / Invalid request");
		}
	
		return token;
	
	}

}
