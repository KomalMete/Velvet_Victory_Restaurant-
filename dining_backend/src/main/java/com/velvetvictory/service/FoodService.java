package com.velvetvictory.service;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.velvetvictory.dto.request.FoodRequest;

public interface FoodService {

	Object saveOrUpdateFood(FoodRequest foodRequest, MultipartFile file);

	Object searchByFoodName(String name, Pageable pageable);

	Object getFoodById(Long id);

}
