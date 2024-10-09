package com.velvetvictory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.velvetvictory.dto.request.RestaurantsRequest;
import com.velvetvictory.dto.response.CustomEntityResponse;
import com.velvetvictory.dto.response.EntityResponse;
import com.velvetvictory.service.RestaurantsService;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantsController {

	@Autowired
	private RestaurantsService restaurantsService;
	
	@PostMapping("/addRestaurant")
	public ResponseEntity<?> addRestaurant(@RequestBody RestaurantsRequest restaurantsRequest)
	{
		 try
	        {
	            return new ResponseEntity(new EntityResponse(restaurantsService.addRestaurant(restaurantsRequest), 0), HttpStatus.OK);
	        }
	        catch (Exception e)
	        {
	            return  new ResponseEntity( new CustomEntityResponse(e.getMessage(), -1), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	}
	
	@GetMapping("/getAllRestaurants")
	public ResponseEntity<?> getAllRestaurants()
	{
		try
		{
			System.out.println("in restaurant try block");
			return new ResponseEntity(new EntityResponse(restaurantsService.getAllRestaurants(), 0), HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println("in restaurant catch block");
			return new ResponseEntity(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteRestaurantById")
	public ResponseEntity<?> deleteRestaurantById(@RequestParam (name = "restaurantId")Long restaurantId)
    {
        try
        {
            return new ResponseEntity(new EntityResponse(restaurantsService.deleteRestaurantById(restaurantId), 0), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@GetMapping("/getAllRestaurantsFromFoodCategory")
	public ResponseEntity<?> getAllRestaurantsFromFoodCategory(@RequestParam (name = "foodCategoryId")Long foodCategoryId)
	{
		try
		{
			return new ResponseEntity(new EntityResponse(restaurantsService.getAllRestaurantsFromFoodCategory(foodCategoryId), 0), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.OK);
		}
	}
	
	@GetMapping("/getAllRestaurantsFromFoodName")
	public ResponseEntity<?> getAllRestaurantsFromFoodName(@RequestParam (name = "foodName")String foodName)
	{
		try
		{
			return new ResponseEntity(new EntityResponse(restaurantsService.getAllRestaurantsFromFoodName(foodName), 0), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.OK);
		}
	}
	
	@GetMapping("/getAllRestaurantsFromFoodCategoryName")
	public ResponseEntity<?> getAllRestaurantsFromFoodCategoryName(@RequestParam (name = "CategoryName")String CategoryName)
	{
		try
		{
			return new ResponseEntity(new EntityResponse(restaurantsService.getAllRestaurantsFromFoodCategoryName(CategoryName), 0), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.OK);
		}
	}
}
