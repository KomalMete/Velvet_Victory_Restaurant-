package com.velvetvictory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.velvetvictory.dto.request.FoodRequest;
import com.velvetvictory.dto.response.CustomEntityResponse;
import com.velvetvictory.dto.response.EntityResponse;
import com.velvetvictory.service.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {

	@Autowired
	private FoodService foodService;
	
	@PostMapping("/saveOrUpdateFood")
	public ResponseEntity<?> saveOrUpdateFood(@RequestBody FoodRequest foodRequest, 
									@RequestParam (name = "file") MultipartFile file)
	{
		try
		{
			System.out.println("in controller try block");
			return new ResponseEntity(new EntityResponse(foodService.saveOrUpdateFood(foodRequest, file), 0), HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println("in controller catch block");
			return new ResponseEntity(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.BAD_REQUEST);
		}
	}
}
