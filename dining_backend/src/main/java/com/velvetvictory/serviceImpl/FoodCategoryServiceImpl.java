package com.velvetvictory.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velvetvictory.dto.request.FoodCategoryRequest;
import com.velvetvictory.models.FoodCategory;
import com.velvetvictory.repository.FoodCategoryRepository;
import com.velvetvictory.service.FoodCategoryService;

@Service
public class FoodCategoryServiceImpl implements FoodCategoryService{
	
	@Autowired
	private FoodCategoryRepository foodCategoryRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(FoodCategoryServiceImpl.class);

	@Override
	public Object addFoodCategory(FoodCategoryRequest foodCategoryRequest) {
		
		logger.info("Starting addFoodCategory method.");
		
		if(foodCategoryRequest != null)
		{
			System.out.println("in if block");
			FoodCategory category = new FoodCategory();
			category.setId(foodCategoryRequest.getId());
			category.setCategoryName(foodCategoryRequest.getCategoryName());
		FoodCategory savedCategory	= foodCategoryRepo.save(category);
			
			 logger.info("food category details saved successfully for ID: {}", savedCategory.getId());
			
			System.out.println("food category save");
			return "FoodCategory saved successfully..";
		}
		else
		{
			System.out.println("food category not save");
			return "FoodCategory name cant be null..";
		}
		
	}

	@Override
	public Object getAllFoodCategory() {
		
		return foodCategoryRepo.findAll();
	}

	@Override
	public Object deleteById(Long foodCategoryId) {
		if(foodCategoryId <= 0 && foodCategoryId == null)
		{
			return "FoodCategory ID cannot be null..";
		}
		else
		{
			foodCategoryRepo.deleteById(foodCategoryId);
			return "FoodCategory deleted successfully...";
		}
	}

}
