package com.velvetvictory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.velvetvictory.dto.request.ChangePasswordDTO;
import com.velvetvictory.dto.request.CustomerRequest;
import com.velvetvictory.dto.request.FoodCategoryRequest;
import com.velvetvictory.dto.request.LoginDTO;
import com.velvetvictory.dto.response.CustomEntityResponse;
import com.velvetvictory.dto.response.EntityResponse;
import com.velvetvictory.service.CustomerService;

@RestController
@RequestMapping("/user")
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<?> addCustomer(@RequestBody CustomerRequest customerRequest)
	{
		try
		{
			System.out.println("in controller try block");
			return new ResponseEntity(new EntityResponse(customerService.addCustomer(customerRequest), 0), HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println("in controller catch block");
			return new ResponseEntity(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/deleteById")
    public ResponseEntity<?> deleteCustomerById(@RequestParam (name = "customerId") Long id)
    {
        try
        {
            return new ResponseEntity(new EntityResponse(customerService.deleteCustomerById(id), 0), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.OK);
        }
    }
	
	@PostMapping("/customerLogin")
	public ResponseEntity<?>customerLogin(@RequestBody LoginDTO dto)
	{
		 try
	        {
	            return new ResponseEntity(new EntityResponse(customerService.customerLogin(dto), 0), HttpStatus.OK);
	        }
	        catch (Exception e)
	        {
	            return new ResponseEntity<>(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.OK);
	        }
	}
	
	@PutMapping("/forgotPassword")
	public ResponseEntity<?>forgotPassword(@RequestBody LoginDTO dto)
	{
		 try
	        {
	            return new ResponseEntity(new EntityResponse(customerService.forgotPassword(dto), 0), HttpStatus.OK);
	        }
	        catch (Exception e)
	        {
	            return new ResponseEntity<>(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.OK);
	        }
	}
	
	@PutMapping("/changePassword")
	public ResponseEntity<?>changePassword(@RequestBody ChangePasswordDTO changePasswordDTO)
	{
		 try
	        {
	            return new ResponseEntity(new EntityResponse(customerService.changePassword(changePasswordDTO), 0), HttpStatus.OK);
	        }
	        catch (Exception e)
	        {
	            return new ResponseEntity<>(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.OK);
	        }
	}
}
