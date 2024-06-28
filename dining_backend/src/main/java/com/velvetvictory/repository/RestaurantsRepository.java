package com.velvetvictory.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.velvetvictory.models.Food;
import com.velvetvictory.models.Restaurants;

public interface RestaurantsRepository extends JpaRepository<Restaurants, Long> {

	//Food findByFoodsId(Long foodId);
	
	Restaurants findByFoodsId(Long foodId);
}