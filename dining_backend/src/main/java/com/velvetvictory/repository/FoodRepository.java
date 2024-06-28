package com.velvetvictory.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.velvetvictory.models.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long>
{
	//after where db term use as food_name bec considering its a sql query
	@Query(value = "select * from food where food_name like %:name%", nativeQuery = true)
	Page findByName(String name, Pageable pageable);
	
	List<Food> findByRestaurants(Long restaurantId);
	
	Set<Food> findByFoodCategoryCategoryName(String categoryName);
}
