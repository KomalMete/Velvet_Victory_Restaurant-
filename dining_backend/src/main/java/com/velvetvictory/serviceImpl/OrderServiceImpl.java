package com.velvetvictory.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velvetvictory.dto.request.OrderDTO;
import com.velvetvictory.dto.request.PaymentDTO;
import com.velvetvictory.models.Customer;
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

	public Object getAllOrders(String customerEmail)
	{
		Customer customer = customerRepository.findByEmail(customerEmail);
		
		List<Orders> orders = orderRepository.getAllOrdersFromCustomerId(customer.getId());
		
		List<OrderDTO> listOfOrders = new ArrayList<OrderDTO>();
		
			for(Orders order : orders)
			{
				OrderDTO orderDTO = new OrderDTO();
				orderDTO.setOrderId(order.getOrderId());
				orderDTO.setPaymentId(order.getPaymentId());
				orderDTO.setStatus(order.getStatus());
				orderDTO.setTotalPrice(order.getTotalPrice());
				orderDTO.setAddress(order.getAddress());
				orderDTO.setCustomer(customer);
				orderDTO.setRestaurant(order.getRestaurant());
				
				listOfOrders.add(orderDTO);
			}
		
		if(!listOfOrders.isEmpty())
		{
			return listOfOrders;
		}
		else
		{
			return "No orders placed yet..";
		}
	}

}
