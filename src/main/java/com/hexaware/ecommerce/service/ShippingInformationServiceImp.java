package com.hexaware.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hexaware.ecommerce.dto.ShippingInformationDTO;
import com.hexaware.ecommerce.entities.ShippingInformation;
import com.hexaware.ecommerce.repository.ShippingInformationRepository;

@Service
public class ShippingInformationServiceImp implements IShippingInformation {

	@Autowired
	ShippingInformationRepository shippingRepo;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public ShippingInformation addShippingInformation(ShippingInformationDTO shippingInformationDTO) {

		ShippingInformation shippingInformation = new ShippingInformation();
		shippingInformation.setShippingId(shippingInformationDTO.getShippingId());
		shippingInformation.setFirstName(shippingInformationDTO.getFirstName());
		shippingInformation.setLastName(shippingInformationDTO.getLastName());
		shippingInformation.setShippingAddress(shippingInformationDTO.getShippingAddress());
		shippingInformation.setShippingCity(shippingInformationDTO.getShippingCity());
		shippingInformation.setPostalCode(shippingInformationDTO.getPostalCode());
		return shippingRepo.save(shippingInformation);

	}

	@Override
	public ShippingInformation updateShippingInformation(ShippingInformationDTO shippingInformationDTO) {

		ShippingInformation shippingInformation = shippingRepo.findById(shippingInformationDTO.getShippingId())
				.orElse(new ShippingInformation());
		shippingInformation.setShippingId(shippingInformationDTO.getShippingId());
		shippingInformation.setFirstName(shippingInformationDTO.getFirstName());
		shippingInformation.setLastName(shippingInformationDTO.getLastName());
		shippingInformation.setShippingAddress(shippingInformationDTO.getShippingAddress());
		shippingInformation.setShippingCity(shippingInformationDTO.getShippingCity());
		shippingInformation.setPostalCode(shippingInformationDTO.getPostalCode());
		return shippingRepo.save(shippingInformation);
	}

	@Override
	public void deleteShippingInformation(int shippingId) {
		ShippingInformation shippingInformation = shippingRepo.findById(shippingId).orElse(null);
		shippingRepo.delete(shippingInformation);

	}

	@Override
	public ShippingInformationDTO getShippingInformationById(int shippingId) {
		ShippingInformation shippingInformation = shippingRepo.findById(shippingId).orElse(new ShippingInformation());
		return new ShippingInformationDTO(shippingInformation.getShippingId(), shippingInformation.getFirstName(),
				shippingInformation.getLastName(), shippingInformation.getShippingAddress(),
				shippingInformation.getShippingCity(), shippingInformation.getPostalCode());

	}

	@Override
	public List<ShippingInformation> getAllShippingInformations() {
		return shippingRepo.findAll(Sort.by("shippingId"));
	}

}
