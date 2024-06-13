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
				food.setName(foodRequest.getName());
				food.setDiscription(foodRequest.getDiscription());
				food.setPrice(foodRequest.getPrice());
				food.setFoodCategory(foodRequest.getFoodCategory());
				food.setImage(imagePath);
				//food.setRestaurants(foodRequest.getRestaurants());
				
				foodRepo.save(food);
				return "Food details updated successfully..";
			}
			else
			{
				food = new Food();
				food.setId(foodRequest.getId());
				food.setName(foodRequest.getName());
				food.setDiscription(foodRequest.getDiscription());
				food.setPrice(foodRequest.getPrice());
				food.setFoodCategory(foodRequest.getFoodCategory());
				food.setImage(imagePath);
				
				foodRepo.save(food);
				return "Food details saved successfully..";
			}
			
//			//Set<Restaurants> restaurants = new HashSet<>();
//			
//			//Long restaurantId = foodRequest.getRestaurants().getId();
//			Restaurants restaurant = restaurantsRepo.findById(restaurantId).orElse(null);
//			
//			if(restaurant != null)
//			{
//				restaurantsRepo.save(restaurant);
//			}
//			
//			//food.setRestaurants(foodRequest.getRestaurants());
		} 
		catch (IOException e)
		{
			e.printStackTrace();
			return "Food details doesnt exist..";
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

}
