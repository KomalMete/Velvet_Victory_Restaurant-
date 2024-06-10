package com.velvetvictory.service;

import com.velvetvictory.dto.request.FoodCategoryRequest;

public interface FoodCategoryService {

	Object addFoodCategory(FoodCategoryRequest foodCategoryRequest);

	Object getAllFoodCategory();

	Object deleteById(Long foodCategoryId);

}
