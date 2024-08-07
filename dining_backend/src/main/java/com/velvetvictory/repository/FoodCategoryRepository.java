package com.velvetvictory.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velvetvictory.models.Food;
import com.velvetvictory.models.FoodCategory;

@Repository
public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {

	FoodCategory findByCategoryName(String categoryName);
	
	//boolean findByCategoryName(String categoryName);
	
	
}
 
