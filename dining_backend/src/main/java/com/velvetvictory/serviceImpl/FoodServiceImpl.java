package com.velvetvictory.serviceImpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.velvetvictory.dto.request.FoodRequest;
import com.velvetvictory.models.Food;
import com.velvetvictory.repository.FoodRepository;
import com.velvetvictory.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {
	
	@Autowired
	private FoodRepository foodRepo;
	
	@Autowired
	private FileStorageService fileStorageService;

	@Override
	public Object saveOrUpdateFood(FoodRequest foodRequest, MultipartFile file) {
		
		String imagePath;
		try
		{
			imagePath = fileStorageService.storeFile(file);
			if(foodRepo.existsById(foodRequest.getId()))
			{
				Food food = foodRepo.findById(foodRequest.getId()).get();
				food.setName(foodRequest.getName());
				food.setDiscription(foodRequest.getDiscription());
				food.setPrice(foodRequest.getPrice());
				food.setFoodCategory(foodRequest.getFoodCategory());
				food.setImage(imagePath);
				
				foodRepo.save(food);
				return "Food details updated successfully..";
			}
			else
			{
				Food food = new Food();
				food.setId(foodRequest.getId());
				food.setName(foodRequest.getName());
				food.setDiscription(foodRequest.getDiscription());
				food.setPrice(foodRequest.getPrice());
				food.setFoodCategory(foodRequest.getFoodCategory());
				food.setImage(imagePath);
				
				foodRepo.save(food);
				return "Food details saved successfully..";
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
			return "Food details doesnt exist..";
		}
		
	}

}