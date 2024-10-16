package com.velvetvictory.serviceImpl;

import java.util.*;

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

		System.out.println("in restaurant service block");
		List<Restaurants> restaurants = restaurantRepo.findAll();
//		List<String> restaurantNames = null;
//		for(Restaurants restaurants1 : restaurants)
//		{
//			restaurantNames.add(restaurants1.getRestaurantName());
//		}

		return restaurants;
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
		//Set<Food> food = foodRepo.findByFoodCategoryCategoryName(foodCategory.getCategoryName());
		List<Long> foodIds = foodRepo.getFoodIdsByCategory(foodCategoryId);
		
		System.out.println(foodIds);
		List<Long> restaurantIds = new ArrayList<Long>();
		
		List<Restaurants> restaurantList = new ArrayList<>();
		if(!foodIds.isEmpty())
		{
			restaurantIds = restaurantRepo.getRestaurantIdsByFoodIds(foodIds);
		}
		if(!restaurantIds.isEmpty())
		{
			restaurantList = restaurantRepo.getALLRestaurantByIds(restaurantIds);
		
		}
		for(Restaurants restaurants2 : restaurantList)
		{
			RestaurantDTO restaurantDTO = new RestaurantDTO();
			
			restaurantDTO.setId(restaurants2.getId());
			restaurantDTO.setRestaurantName(restaurants2.getRestaurantName());
			restaurantDTO.setRestaurantImage(restaurants2.getRestaurantImage());
			
			restaurants.add(restaurantDTO);
		}
		
		return restaurants;
	}

	@Override
	public Object getAllRestaurantsFromFoodName(String foodName)
	{
		//retrieve food
		List<Long> foodIds= foodRepo.findByName(foodName);
		
		List<Long> restaurantIds = new ArrayList<Long>();
		
		//list to return to dto
		List<Restaurants> restaurantList = new ArrayList<>();
		
		//to return set of restaurants
		Set<RestaurantDTO> restaurants = new HashSet<>();
		
		if(!foodIds.isEmpty())
		{
			restaurantIds = restaurantRepo.getRestaurantIdsByFoodIds(foodIds);
			
			if(!restaurantIds.isEmpty())
			{
				restaurantList = restaurantRepo.getALLRestaurantByIds(restaurantIds);
				
				for(Restaurants restaurants2 : restaurantList)
				{
					RestaurantDTO restaurantDTO = new RestaurantDTO();
					
					restaurantDTO.setId(restaurants2.getId());
					restaurantDTO.setRestaurantName(restaurants2.getRestaurantName());
					
					restaurants.add(restaurantDTO);
				}
				
				return restaurants;
			}
			else
			{
				return "No restaurant found with that Food Name";
			}
		}
		else
		{
			return "No food found with that name";
		}
		
	}

	@Override
	public Object getAllRestaurantsFromFoodCategoryName(String CategoryName)
	{
		//0.get all categoryIds
		List<Long> categoryIds = foodRepo.getCategoryIdsByCategoryName(CategoryName);
		
		//1.get foods from category
		List<Long> foodIds = foodRepo.getFoodIdsByCategoryIds(categoryIds);
		
		//2.get restaurants from food
		List<Long> restaurantsIds = new ArrayList<Long>();
		
		//3.to return list to dto
		List<Restaurants> finalRestaurants = new ArrayList<Restaurants>();
		
		//4.to avoid lazy initialization
		Set<RestaurantDTO> restaurants = new HashSet<RestaurantDTO>();
		
	
		
		if(!foodIds.isEmpty())
		{
			restaurantsIds = restaurantRepo.getRestaurantIdsByFoodIds(foodIds);
			
			if(!restaurantsIds.isEmpty())
			{
				finalRestaurants = restaurantRepo.getALLRestaurantByIds(restaurantsIds);
				
				for(Restaurants restaurants2 :finalRestaurants)
				{
					RestaurantDTO restaurantDTO = new RestaurantDTO();
					
					restaurantDTO.setId(restaurants2.getId());
					restaurantDTO.setRestaurantName(restaurants2.getRestaurantName());
					
					restaurants.add(restaurantDTO);
				}
				return restaurants;
			}
			else
			{
				return "No Restaurant found with given food";
			}
		}
		else
		{
			return "No food found with given category name";
		}
		
	}

	

}
