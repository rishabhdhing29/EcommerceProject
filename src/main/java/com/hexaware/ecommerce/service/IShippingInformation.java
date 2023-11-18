package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.dto.ShippingInformationDTO;
import com.hexaware.ecommerce.entities.ShippingInformation;

public interface IShippingInformation {

	public ShippingInformation addShippingInformation(ShippingInformationDTO shippingInformationDTO);

	public ShippingInformation updateShippingInformation(ShippingInformationDTO shippingInformationDTO);

	public void deleteShippingInformation(int shippingId);

	public ShippingInformationDTO getShippingInformationById(int shippingId);

	public List<ShippingInformation> getAllShippingInformations();
}
