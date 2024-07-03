package com.velvetvictory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.velvetvictory.dto.request.CartDTO;
import com.velvetvictory.dto.response.CustomEntityResponse;
import com.velvetvictory.dto.response.EntityResponse;
import com.velvetvictory.repository.CartRepository;
import com.velvetvictory.repository.CustomerRepository;
import com.velvetvictory.repository.FoodRepository;
import com.velvetvictory.repository.RestaurantsRepository;
import com.velvetvictory.service.CartService;
import com.velvetvictory.service.CustomerService;
import com.velvetvictory.service.FoodService;
import com.velvetvictory.service.RestaurantsService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private FoodService foodService;
	
	@Autowired
	private RestaurantsService restaurantService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/addFoodToCart")
	public ResponseEntity<?> addFoodToCart(@RequestBody CartDTO cartDTO)
	{
		 try
	        {
	            return new ResponseEntity(new EntityResponse(cartService.addFoodToCart(cartDTO), 0), HttpStatus.OK);
	        }
	        catch (Exception e)
	        {
	            return  new ResponseEntity( new CustomEntityResponse(e.getMessage(), -1), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	}
	
	@DeleteMapping("/removeFoodFromCart")
	public ResponseEntity<?> removeFoodFromCart(@RequestParam (name = "cartId") Long cartId)
	{
		 try
	        {
	            return new ResponseEntity(new EntityResponse(cartService.removeFoodFromCart(cartId), 0), HttpStatus.OK);
	        }
	        catch (Exception e)
	        {
	            return  new ResponseEntity( new CustomEntityResponse(e.getMessage(), -1), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	}
	
	@GetMapping("/getAllFoodItemsFromCart")
	public ResponseEntity<?> getAllFoodItemsFromCart(@RequestParam (name = "customerEmail") String customerEmail)
	{
		 try
	        {
	            return new ResponseEntity(new EntityResponse(cartService.getAllFoodItemsFromCart(customerEmail), 0), HttpStatus.OK);
	        }
	        catch (Exception e)
	        {
	            return  new ResponseEntity( new CustomEntityResponse(e.getMessage(), -1), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	}
	
	@PutMapping("/increaseFoodQuantity")
	public ResponseEntity<?> increaseFoodQuantity(@RequestParam (name = "cartId") Long cartId,
												  @RequestParam (name = "customerEmail") String customerEmail)
	{
		 try
	        {
	            return new ResponseEntity(new EntityResponse(cartService.increaseFoodQuantity(cartId, customerEmail), 0), HttpStatus.OK);
	        }
	        catch (Exception e)
	        {
	            return  new ResponseEntity( new CustomEntityResponse(e.getMessage(), -1), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	}
	
	@PutMapping("/decreaseFoodQuantity")
	public ResponseEntity<?> decreaseFoodQuantity(@RequestParam (name = "cartId") Long cartId,
												  @RequestParam (name = "customerEmail") String customerEmail)
	{
		 try
	        {
	            return new ResponseEntity(new EntityResponse(cartService.decreaseFoodQuantity(cartId, customerEmail), 0), HttpStatus.OK);
	        }
	        catch (Exception e)
	        {
	            return  new ResponseEntity( new CustomEntityResponse(e.getMessage(), -1), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	}
}
