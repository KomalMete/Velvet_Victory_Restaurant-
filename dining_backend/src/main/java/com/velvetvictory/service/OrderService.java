package com.velvetvictory.service;

import com.velvetvictory.dto.request.OrderDTO;

public interface OrderService {

	Object placeOrder(OrderDTO orderDTO);

	Object getAllOrders(String customerEmail);

}
