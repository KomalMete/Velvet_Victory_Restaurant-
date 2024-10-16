package com.velvetvictory.serviceImpl;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.velvetvictory.dto.request.FoodDTO;
import com.velvetvictory.dto.request.FoodRequest;
import com.velvetvictory.models.Food;
import com.velvetvictory.models.FoodCategory;
import com.velvetvictory.models.Restaurants;
import com.velvetvictory.repository.FoodCategoryRepository;
import com.velvetvictory.repository.FoodRepository;
import com.velvetvictory.repository.RestaurantsRepository;
import com.velvetvictory.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {
	
	@Autowired
	private FoodRepository foodRepo;
	
	@Autowired
	private FileStorageService fileStorageService;
	
	@Autowired
	private RestaurantsRepository restaurantsRepo;
	
	@Autowired
	private FoodCategoryRepository foodCategoryRepo;

	@Override
	@Transactional
	public Object saveOrUpdateFood(FoodRequest foodRequest, MultipartFile file) {
		
		String imagePath;
		try
		{
			imagePath = fileStorageService.storeFile(file);
			Food food ;
			if(foodRepo.existsById(foodRequest.getId()))
			{
				food = foodRepo.findById(foodRequest.getId()).get();
			}
			else
			{
				food = new Food();
				food.setId(foodRequest.getId());
			}
			
			food.setName(foodRequest.getName());
			food.setDiscription(foodRequest.getDiscription());
			food.setPrice(foodRequest.getPrice());
			food.setFoodCategory(foodRequest.getFoodCategory());
			food.setImage(imagePath);
		
			food = foodRepo.save(food);
			
			//for restaurant
		    Set<Restaurants> restaurants = new HashSet<Restaurants>();
		    
		    for(Restaurants res : foodRequest.getRestaurants())
		    {
		    	if(restaurantsRepo.existsById(res.getId()))
		    	{
		    		res = restaurantsRepo.findById(res.getId()).get();
		    	}
		    	else
		    	{
		    		restaurantsRepo.save(res);
		    	}
		    	
		    	 food.addRestaurants(res);
		    	 restaurants.add(res);
		    	 
		    }
		    
		    food.setRestaurants(restaurants);
		    foodRepo.save(food);
		    
		    
		    return "Food details saved successfully..";
		    
		    //this type of entry is expected in postman
//		   {
//		    "id": 0,
//		    "name": "Mexican Fiesta Thin n Crispy",
//		    "discription": "New Thin n Crispy crust topped with spiced paneer, spicy red paprika, delicious tandoori sauce and cheese",
//		    "price": 749,
//		    "foodCategory": {
//		        "id": 5
//		    },
//		    "restaurants": [
//		        {
//		            "id": 4
//		        }
//	        	{
//            		"id": 5
//        		}
//		    ]
//		}

		} 
		
		catch (IOException e) {
            e.printStackTrace();
            return "Error saving food details: " + e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return "Unexpected error: " + e.getMessage();
        }
		
	}


	@Override
	public Object searchByFoodName(String name, Pageable pageable) {
		
		if(name != null && !name.isEmpty())
		{
		   return foodRepo.findByName(name,pageable);
		}
		else
		{
			return "Food doesnt exist..";
		}
	}


	@Override
	public Object getFoodById(Long id) {
		
		if(foodRepo.existsById(id))
		{
			Food food =  foodRepo.findById(id).get();
			return food;
		}
		else
		{
			return "Food doesnt exist...";
		}
	}


	@Override
	@Transactional
	public Object deleteFoodByIdFromRestaurant(Long foodId, Long restaurantId)
	{
		Restaurants restaurant = restaurantsRepo.findById(restaurantId).orElseThrow(() -> new IllegalArgumentException("Restaurant doesnt exist"));
		
		try {
		Food food = foodRepo.findById(foodId).get();
		restaurant.removeFood(food);
		restaurantsRepo.save(restaurant);
		//foodRepo.deleteById(food.getId());
		
		return "Food deleted from restaurant";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "Food not deleted from restaurant";
		}
	}

	

	@Override
	@Transactional
	public Object getAllFoodOfRestaurant(Long restaurantId)
	{
		
		Restaurants restaurant = restaurantsRepo.findById(restaurantId).orElseThrow(() -> new IllegalArgumentException("Restaurant doesnt exist"));
		Set<FoodDTO> food = new HashSet<FoodDTO>();
		//using dto as in its a safest way to load all food items
		for(Food foods : restaurant.getFoods())
		{
			FoodDTO foodDto = new FoodDTO();
			
			foodDto.setId(foods.getId());
			foodDto.setName(foods.getName());
			foodDto.setDiscription(foods.getDiscription());
			foodDto.setImage(foods.getImage());
			foodDto.setPrice(foods.getPrice());
			foodDto.setRestaurantName(restaurant.getRestaurantName());
			
			food.add(foodDto);
		}
		return food;
	}

	@Override
	@Transactional
	public Object deleteMultipleFoodByIdFromRestaurant(Set<Food> foodIds, Long restaurantId)
	{
		Restaurants restaurant = restaurantsRepo.findById(restaurantId).orElseThrow(() -> new IllegalArgumentException("Restaurant doesnt exist"));
		
		Set<Food> setFoods;
		try
		{
			for(Food foods : foodIds)
			{
				Food food = foodRepo.findById(foods.getId()).get();
				restaurant.removeFood(food);
				restaurantsRepo.save(restaurant);
			}
			
			return "Food items deleted from restaurant";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "Food not deleted from restaurant";
		}
		
		
	}

	@Override
	@Transactional
	public Object getAllFoodFromCategory(String foodCategoryName)
	{
		try 
		{
			FoodCategory category = foodCategoryRepo.findByCategoryName(foodCategoryName);
			
			Set<Food> food = foodRepo.findByFoodCategoryCategoryName(foodCategoryName);
			
			//safest way to do operation so it wont give error of lazy initialization
			Set<FoodDTO> foods = new HashSet<>();
			for(Food foodItems : food)
			{
				FoodDTO foodDto = new FoodDTO();
				
				foodDto.setId(foodItems.getId());
				foodDto.setName(foodItems.getName());
				foodDto.setDiscription(foodItems.getDiscription());
				foodDto.setPrice(foodItems.getPrice());
				foodDto.setImage(foodItems.getImage());
				
				foods.add(foodDto);
			}
			return foods;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "Food category not found";
		}
	
	}

}
