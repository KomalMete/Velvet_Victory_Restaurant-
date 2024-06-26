package com.velvetvictory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.velvetvictory.dto.request.AddressRequest;
import com.velvetvictory.dto.response.CustomEntityResponse;
import com.velvetvictory.dto.response.EntityResponse;
import com.velvetvictory.service.AddressService;

@RestController
@RequestMapping("/api")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@PostMapping("/saveOrUpdateAddress")
	public ResponseEntity<?> saveOrUpdateAddress(@RequestBody AddressRequest addressRequest)
	{
		try
		{
			return new ResponseEntity( new EntityResponse(addressService.saveOrUpdateAddress(addressRequest), 0), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getAllAddress")
	public ResponseEntity<?> getAllAddress(@RequestParam(name = "email") String email)
	{
		try
		{
			return new ResponseEntity( new EntityResponse(addressService.getAllAddress(email), 0), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteAddressById")
	public ResponseEntity<?> deleteAddressById(@RequestParam(name = "addressId") Long addressId,
												@RequestParam(name = "email") String email)
	{
		try
		{
			return new ResponseEntity( new EntityResponse(addressService.deleteAddressById(addressId,email), 0), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.BAD_REQUEST);
		}
	}
}
