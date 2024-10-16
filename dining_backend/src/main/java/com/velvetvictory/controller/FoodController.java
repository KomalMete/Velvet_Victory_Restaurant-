package com.velvetvictory.controller;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.velvetvictory.dto.request.FoodRequest;
import com.velvetvictory.dto.response.CustomEntityResponse;
import com.velvetvictory.dto.response.EntityResponse;
import com.velvetvictory.models.Food;
import com.velvetvictory.service.FoodService;

@RestController
@CrossOrigin
@RequestMapping("/food")
public class FoodController {

	@Autowired
	private FoodService foodService;
	
	@PostMapping("/saveOrUpdateFood")
	public ResponseEntity<?> saveOrUpdateFood(@RequestParam (name = "foodRequest") String FoodRequestJson, 
									@RequestParam (name = "file") MultipartFile file)
	{
		try
		{
			ObjectMapper objectMapper = new ObjectMapper();
			FoodRequest foodRequest = objectMapper.readValue(FoodRequestJson, FoodRequest.class);
			
			System.out.println("in controller try block");
			return new ResponseEntity(new EntityResponse(foodService.saveOrUpdateFood(foodRequest, file), 0), HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println("in controller catch block");
			return new ResponseEntity(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/searchByFoodName")
	public ResponseEntity<?> searchByFoodName(@RequestParam (required = false , defaultValue = "0") Integer pageNo,
											  @RequestParam (required = false , defaultValue = "5") Integer pageSize,
											  @RequestParam (name = "name") String name
											)
	{
		try
		{
			Pageable pageable = PageRequest.of(pageNo,pageSize);
			return new ResponseEntity( new EntityResponse(foodService.searchByFoodName(name,pageable), 0), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getFoodById")
	public ResponseEntity<?> getFoodById(@RequestParam (name ="id") Long id)
	{
		try
		{
			return new ResponseEntity( new EntityResponse(foodService.getFoodById(id), 0), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteFoodByIdFromRestaurant")
	public ResponseEntity<?> deleteFoodByIdFromRestaurant(@RequestParam (name = "foodId") Long foodId,
														@RequestParam (name = "restaurantId") Long restaurantId)
	{
		try
		{
			return new ResponseEntity( new EntityResponse(foodService.deleteFoodByIdFromRestaurant(foodId, restaurantId), 0), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.BAD_REQUEST);
		}
	}
	

	@DeleteMapping("/deleteMultipleFoodByIdFromRestaurant")
	public ResponseEntity<?> deleteMultipleFoodByIdFromRestaurant(@RequestParam (name = "foodId") Set<Food> foodIds,
														@RequestParam (name = "restaurantId") Long restaurantId)
	{
		try
		{
			return new ResponseEntity( new EntityResponse(foodService.deleteMultipleFoodByIdFromRestaurant(foodIds, restaurantId), 0), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getAllFoodOfRestaurant")
	public ResponseEntity<?> getAllFoodOfRestaurant(@RequestParam (name ="restaurantId") Long restaurantId)
	{
		try
		{
			return new ResponseEntity( new EntityResponse(foodService.getAllFoodOfRestaurant(restaurantId), 0), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getAllFoodFromCategory")
	public ResponseEntity<?> getAllFoodFromCategory(@RequestParam (name ="foodCategoryName") String foodCategoryName)
	{
		try
		{
			return new ResponseEntity( new EntityResponse(foodService.getAllFoodFromCategory(foodCategoryName), 0), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
