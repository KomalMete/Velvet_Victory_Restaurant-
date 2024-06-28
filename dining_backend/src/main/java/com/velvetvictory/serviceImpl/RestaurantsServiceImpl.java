package com.velvetvictory.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velvetvictory.dto.request.RestaurantDTO;
import com.velvetvictory.dto.request.RestaurantsRequest;
import com.velvetvictory.models.Food;
import com.velvetvictory.models.FoodCategory;
import com.velvetvictory.models.Restaurants;
import com.velvetvictory.repository.FoodCategoryRepository;
import com.velvetvictory.repository.FoodRepository;
import com.velvetvictory.repository.RestaurantsRepository;
import com.velvetvictory.service.RestaurantsService;

@Service
public class RestaurantsServiceImpl implements RestaurantsService{
	
	@Autowired
	private RestaurantsRepository restaurantRepo;
	
	@Autowired
	private FoodCategoryRepository foodCategoryRepo;
	
	@Autowired
	private FoodRepository foodRepo;

	@Override
	public Object addRestaurant(RestaurantsRequest restaurantsRequest) {
		
		if(restaurantsRequest == null)
		{
			return "Restaurant cant be null";
		}
		else
		{
			Restaurants restaurant = new Restaurants();
			restaurant.setId(restaurantsRequest.getId());
			restaurant.setRestaurantName(restaurantsRequest.getRestaurantName());
			
			restaurantRepo.save(restaurant);
			return "Restaurant added successfully..";
		}
	}

	@Override
	public Object getAllRestaurants() {
		// TODO Auto-generated method stub
		return restaurantRepo.findAll();
	}

	@Override
	@Transactional
	public Object deleteRestaurantById(Long restaurantId) {
		
		if(restaurantRepo.existsById(restaurantId))
		{
			Restaurants restaurant = restaurantRepo.findById(restaurantId).get();
			Set<Food> food = restaurant.getFoods();
			
			for(Food food1 : food)
			{
				restaurant.removeFood(food1);
				restaurantRepo.save(restaurant);
			}
					
			restaurantRepo.deleteById(restaurantId);
			return "Restaurant deleted successfully..";
		}
		else
		{
			return "Restaurant doesnt exists";
		}
	}

	@Override
	public Object getAllRestaurantsFromFoodCategory(Long foodCategoryId)
	{
		//food category present or not
		FoodCategory foodCategory = foodCategoryRepo.findById(foodCategoryId).orElseThrow(() -> (new IllegalArgumentException("Category not found")));
		
		//to return set of restaurants
		Set<RestaurantDTO> restaurants = new HashSet<>();
		
		//Retrieving set of food from that category
		Set<Food> food = foodRepo.findByFoodCategoryCategoryName(foodCategory.getCategoryName());
		
		//retrieving set of food ids from category id
		//Set<Long> foodId = foodRepo.findByFoodCategoryId(foodCategory.getId());
		
		for(Food foods : food)
		{
		    //Restaurants restaurants1 = new Restaurants();
			RestaurantDTO restaurantDTO = new RestaurantDTO();
			
			Restaurants restaurants1 = restaurantRepo.findByFoodsId(foods.getId());
			
			restaurantDTO.setId(restaurants1.getId());
			restaurantDTO.setRestaurantName(restaurants1.getRestaurantName());
			
			restaurants.add(restaurantDTO);
		}
		
		return restaurants;
	}

	

}
