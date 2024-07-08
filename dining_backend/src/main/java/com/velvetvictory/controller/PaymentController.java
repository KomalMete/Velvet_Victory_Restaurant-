package com.velvetvictory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velvetvictory.dto.request.PaymentDTO;
import com.velvetvictory.dto.request.RestaurantsRequest;
import com.velvetvictory.dto.response.CustomEntityResponse;
import com.velvetvictory.dto.response.EntityResponse;
import com.velvetvictory.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/transaction")
	public ResponseEntity<?> transaction(@RequestBody PaymentDTO paymentDTO)
	{
		 try
	        {
	            return new ResponseEntity(new EntityResponse(paymentService.transaction(paymentDTO), 0), HttpStatus.OK);
	        }
	        catch (Exception e)
	        {
	            return  new ResponseEntity( new CustomEntityResponse(e.getMessage(), -1), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	}
}
