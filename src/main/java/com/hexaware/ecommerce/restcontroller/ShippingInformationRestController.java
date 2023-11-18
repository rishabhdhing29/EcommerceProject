package com.hexaware.ecommerce.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ecommerce.dto.ShippingInformationDTO;
import com.hexaware.ecommerce.entities.ShippingInformation;
import com.hexaware.ecommerce.service.IShippingInformation;

@RestController
@RequestMapping("/api/shipping")
public class ShippingInformationRestController {

	@Autowired
	private IShippingInformation service;
	
	Logger logger = LoggerFactory.getLogger(ShippingInformationRestController.class);

	@PostMapping("/add")
	@PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER')")
	public ShippingInformation addShippingInformation(@RequestBody ShippingInformationDTO shippingInformationDTO) {
		logger.info("Shipping Info added");
		return service.addShippingInformation(shippingInformationDTO);
	}

	@PutMapping("/update")
	@PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER')")
	public ShippingInformation updateShippingInformation(@RequestBody ShippingInformationDTO shippingInformationDTO) {
		logger.info("Shipping Info updated");
		return service.updateShippingInformation(shippingInformationDTO);
	}

	@DeleteMapping("/delete/{shippingId}")
	@PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER','ROLE_ADMIN')")
	public void deleteById(@PathVariable int shippingId)
	{
		logger.info("Shipping Info deleted");
		service.deleteShippingInformation(shippingId);
	}

	@GetMapping("/get/{shippingId}")
	@PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER','ROLE_ADMIN','ROLE_SELLER')")
	public ShippingInformationDTO getShippingById(@PathVariable int shippingId) {
		return service.getShippingInformationById(shippingId);
	}
	@GetMapping("/getall")
	@PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER','ROLE_ADMIN')")
	public List<ShippingInformation> getAllShippingInformations(){
		return service.getAllShippingInformations();
	}
}
