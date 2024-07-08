package com.velvetvictory.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velvetvictory.dto.request.OrderDTO;
import com.velvetvictory.dto.request.PaymentDTO;
import com.velvetvictory.models.Orders;
import com.velvetvictory.models.Payment;
import com.velvetvictory.repository.CustomerRepository;
import com.velvetvictory.repository.OrderRepository;
import com.velvetvictory.service.OrderService;
import com.velvetvictory.service.PaymentService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PaymentService paymentService;

	public Object placeOrder(OrderDTO orderDTO)
	{
		Orders order = new Orders();
		
		order.setOrderId(orderDTO.getOrderId());
		order.setTotalPrice(orderDTO.getTotalPrice());
		order.setAddress(orderDTO.getAddress());
		order.setCustomer(orderDTO.getCustomer());
		order.setRestaurant(orderDTO.getRestaurant());
		order.setStatus(orderDTO.getStatus());
		order.setPaymentId(orderDTO.getPaymentId());
		order.setFoods(orderDTO.getFoods());
		
		
//		paymentDTO.setId(orderDTO.getPaymentId().getId());
//		paymentDTO.setPaymentMode(orderDTO.getPaymentId().getPaymentMode());
//		
//		Payment payment = paymentService.transaction(paymentDTO);
		
		orderRepository.save(order);
		return "Order placed successfully..";
	}

}
