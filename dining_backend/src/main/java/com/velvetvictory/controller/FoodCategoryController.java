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

import com.velvetvictory.dto.request.FoodCategoryRequest;
import com.velvetvictory.dto.response.CustomEntityResponse;
import com.velvetvictory.dto.response.EntityResponse;
import com.velvetvictory.service.FoodCategoryService;

@RestController
@RequestMapping("/velvet")
public class FoodCategoryController {

	@Autowired
	private FoodCategoryService foodCategoryService;
	
	@PostMapping("/addFoodCategory")
	public ResponseEntity<?> addFoodCategory(@RequestBody FoodCategoryRequest foodCategoryRequest)
	{
		try
		{
			System.out.println("in try block");
			return new ResponseEntity(new EntityResponse(foodCategoryService.addFoodCategory(foodCategoryRequest), 0), HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println("in catch block");
			return new ResponseEntity(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.OK);
		}
	}
	
	@GetMapping("/getAllFoodCategory")
	public ResponseEntity<?> getAllFoodCategory()
	{
		try
		{
			System.out.println("in try block");
			return new ResponseEntity(new EntityResponse(foodCategoryService.getAllFoodCategory(), 0), HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println("in catch block");
			return new ResponseEntity(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/deleteById")
	public ResponseEntity<?> deleteById(@RequestParam (name = "foodCategoryId")Long foodCategoryId)
    {
        try
        {
            return new ResponseEntity(new EntityResponse(foodCategoryService.deleteById(foodCategoryId), 0), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.OK);
        }
    }
	
	
}
