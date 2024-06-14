package com.velvetvictory.serviceImpl;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.velvetvictory.dto.request.FoodRequest;
import com.velvetvictory.models.Food;
import com.velvetvictory.models.Restaurants;
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

	@Override
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
		
			//for restaurant
		    Set<Restaurants> restaurants = new HashSet<>();
		    
		    for(Restaurants res : foodRequest.getRestaurants())
		    {
		    	if(!restaurantsRepo.existsById(res.getId()))
		    	{
		    		restaurantsRepo.save(res);
		    	}
		    	 food.addRestaurant(res);
		    }
		    food.setRestaurants(restaurants);
		    foodRepo.save(food);
		    return "Food details saved successfully..";
		    
		    //this type of entry is expected in postman
//		    {
//		        "id" : 0,
//		        "name" : "Margherita Semizza (Half Pizza)",
//		        "discription" : "Mozzarella Cheese, Fresh Parsley. A classic treat for every cheese lover",
//		        "price" : 175,
//		        "foodCategory" : {
//		            "id" : 5
//		        },
//		    "restaurants" : [{ "id" : 3
//		    }]
//		    }
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

}
