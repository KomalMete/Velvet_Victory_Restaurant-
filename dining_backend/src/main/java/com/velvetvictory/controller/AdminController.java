package com.velvetvictory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.velvetvictory.dto.request.AdminRequest;
import com.velvetvictory.dto.request.CustomerRequest;
import com.velvetvictory.dto.request.LoginDTO;
import com.velvetvictory.dto.response.CustomEntityResponse;
import com.velvetvictory.dto.response.EntityResponse;
import com.velvetvictory.service.AdminService;
import com.velvetvictory.service.CustomerService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/saveOrUpdateAdmin")
	public ResponseEntity<?> saveOrUpdateAdmin(@RequestBody AdminRequest adminRequest)
	{
		try
		{
			System.out.println("in controller try block");
			return new ResponseEntity(new EntityResponse(adminService.saveOrUpdateAdmin(adminRequest), 0), HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println("in controller catch block");
			return new ResponseEntity(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/deleteById")
    public ResponseEntity<?> deleteAdminById(@RequestParam (name = "adminId") Long id)
    {
        try
        {
            return new ResponseEntity(new EntityResponse(adminService.deleteAdminById(id), 0), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.OK);
        }
    }
	
	@PostMapping("/adminLogin")
	public ResponseEntity<?>adminLogin(@RequestBody LoginDTO dto)
	{
		 try
	        {
	            return new ResponseEntity(new EntityResponse(adminService.adminLogin(dto), 0), HttpStatus.OK);
	        }
	        catch (Exception e)
	        {
	            return new ResponseEntity<>(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.OK);
	        }
	}
}
