package com.hexaware.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hexaware.ecommerce.dto.OrderDTO;
import com.hexaware.ecommerce.entities.Order;
import com.hexaware.ecommerce.repository.OrderRepository;

@Service
public class OrderServiceImp implements IOrderService {

	@Autowired
	OrderRepository orderRepo;

	@Autowired
	RestTemplate restTemplate;


	@Override
	public Order createOrder(OrderDTO orderDTO) {
		Order order = new Order();
		order.setOrderID(orderDTO.getOrderID());
		order.setOrderName(orderDTO.getOrderName());
		order.setOrderAmount(orderDTO.getOrderAmount());
		order.setOrderDate(order.getOrderDate());
		order.setPaymentId(orderDTO.getPaymentId());
		return orderRepo.save(order);


	}

	@Override
	public Order updateOrder(OrderDTO orderDTO) {

        Order order = orderRepo.findById(orderDTO.getOrderID()).orElse(new Order());
		order.setOrderID(orderDTO.getOrderID());
		order.setOrderName(orderDTO.getOrderName());
		order.setOrderAmount(orderDTO.getOrderAmount());
		order.setOrderDate(order.getOrderDate());
		order.setPaymentId(orderDTO.getPaymentId());
		return orderRepo.save(order);
	}

	@Override
	public void deleteOrder(int orderId) {
		Order order = orderRepo.findById(orderId).orElse(null);
		orderRepo.delete(order);

	}

	@Override
	public OrderDTO getOrderById(int orderId) {
		Order order = orderRepo.findById(orderId).orElse(new Order());
		return new OrderDTO(order.getOrderID(),order.getOrderName(),order.getOrderAmount(),order.getOrderDate(),order.getPaymentId());
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll(Sort.by("orderName"));
	}

}
