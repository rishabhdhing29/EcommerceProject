package com.hexaware.ecommerce.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ecommerce.dto.OrderDTO;
import com.hexaware.ecommerce.entities.Order;
import com.hexaware.ecommerce.exception.OrderNotFoundException;
import com.hexaware.ecommerce.service.IOrderService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/api/order")
public class OrderRestController {

	@Autowired
	private IOrderService service;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderRestController.class);

	@PostMapping("/add")
	@PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER')")
	public Order createOrder(@RequestBody OrderDTO orderDTO) {
		logger.info("Order added");
		return service.createOrder(orderDTO);
	}

	@PutMapping("/update")
	@PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER')")
	public Order updateOrder(@RequestBody OrderDTO orderDTO) {
		logger.info("Order updated");
		return service.updateOrder(orderDTO);
	}

	@DeleteMapping("/delete/{orderId}")
	@PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER')")
	public void deleteById(@PathVariable int orderId)
	{
		logger.info("Order deleted");
		service.deleteOrder(orderId);
	}

	@GetMapping("/get/{orderId}")
	@PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER','ROLE_SELLER')")
	public OrderDTO getOrderById(@PathVariable @Valid @Min(1) int orderId)throws OrderNotFoundException {
		if(orderId==0) {
			throw new OrderNotFoundException(HttpStatus.BAD_REQUEST,"order not found"+orderId);
		}
		return service.getOrderById(orderId);
	}

	@GetMapping("/getall")
	@PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER','ROLE_SELLER')")
	public List<Order> getAllOrders(){
		return service.getAllOrders();
	}
}
