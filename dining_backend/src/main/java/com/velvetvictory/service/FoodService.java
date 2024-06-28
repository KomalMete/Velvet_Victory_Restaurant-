package com.velvetvictory.service;

import java.util.Set;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.velvetvictory.dto.request.FoodRequest;
import com.velvetvictory.models.Food;

public interface FoodService {

	Object saveOrUpdateFood(FoodRequest foodRequest, MultipartFile file);

	Object searchByFoodName(String name, Pageable pageable);

	Object getFoodById(Long id);

	Object deleteFoodByIdFromRestaurant(Long foodId, Long restaurantId);

	Object getAllFoodOfRestaurant(Long restaurantId);

	Object deleteMultipleFoodByIdFromRestaurant(Set<Food> foodIds, Long restaurantId);

	Object getAllFoodFromCategory(String foodCategoryName);

}
