package com.velvetvictory.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.velvetvictory.models.Food;
import com.velvetvictory.models.Restaurants;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long>
{
	//after where db term use as food_name bec considering its a sql query
	@Query(value = "select * from food where food_name like %:name%", nativeQuery = true)
	Page findByName(String name, Pageable pageable);
	
	List<Food> findByRestaurants(Long restaurantId);
	
	Set<Food> findByFoodCategoryCategoryName(String categoryName);
	
	Set<Long> findByFoodCategoryId(Long categoryId);

	//because we r using nativeQuery = true give parameters as they are present in database tables
	@Query(value = " select DISTINCT(id) from food where food_category_id =:foodCategoryId",nativeQuery = true)
	List<Long> getFoodIdsByCategory(Long foodCategoryId);
	
	@Query(value = " select DISTINCT(id) from food where food_name like  %:foodName%",nativeQuery = true)
	List<Long> findByName(String foodName);
}
