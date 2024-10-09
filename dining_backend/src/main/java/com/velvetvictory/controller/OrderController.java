package com.velvetvictory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.velvetvictory.dto.request.OrderDTO;
import com.velvetvictory.dto.request.RestaurantsRequest;
import com.velvetvictory.dto.response.CustomEntityResponse;
import com.velvetvictory.dto.response.EntityResponse;
import com.velvetvictory.service.OrderService;
import com.velvetvictory.serviceImpl.OrderServiceImpl;

@RestController
@RequestMapping("/orders")
public class OrderController 
{
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/placeOrder")
	public ResponseEntity<?> placeOrder(@RequestBody OrderDTO orderDTO)
	{
		 try
	        {
	            return new ResponseEntity(new EntityResponse(orderService.placeOrder(orderDTO), 0), HttpStatus.OK);
	        }
	        catch (Exception e)
	        {
	            return  new ResponseEntity( new CustomEntityResponse(e.getMessage(), -1), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	}
	
	@GetMapping("/getAllOrders")
	public ResponseEntity<?> getAllOrders(@RequestParam (name = "customerEmail") String customerEmail)
	{
		 try
	        {
	            return new ResponseEntity(new EntityResponse(orderService.getAllOrders(customerEmail), 0), HttpStatus.OK);
	        }
	        catch (Exception e)
	        {
	            return  new ResponseEntity( new CustomEntityResponse(e.getMessage(), -1), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	}
	
}
