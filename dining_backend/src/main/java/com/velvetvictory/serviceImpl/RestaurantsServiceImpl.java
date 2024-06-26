package com.velvetvictory.serviceImpl;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velvetvictory.dto.request.RestaurantsRequest;
import com.velvetvictory.models.Food;
import com.velvetvictory.models.Restaurants;
import com.velvetvictory.repository.RestaurantsRepository;
import com.velvetvictory.service.RestaurantsService;

@Service
public class RestaurantsServiceImpl implements RestaurantsService{
	
	@Autowired
	private RestaurantsRepository restaurantRepo;

	@Override
	public Object addRestaurant(RestaurantsRequest restaurantsRequest) {
		
		if(restaurantsRequest == null)
		{
			return "Restaurant cant be null";
		}
		else
		{
			Restaurants restaurant = new Restaurants();
			restaurant.setId(restaurantsRequest.getId());
			restaurant.setRestaurantName(restaurantsRequest.getRestaurantName());
			
			restaurantRepo.save(restaurant);
			return "Restaurant added successfully..";
		}
	}

	@Override
	public Object getAllRestaurants() {
		// TODO Auto-generated method stub
		return restaurantRepo.findAll();
	}

	@Override
	@Transactional
	public Object deleteRestaurantById(Long restaurantId) {
		
		if(restaurantRepo.existsById(restaurantId))
		{
			Restaurants restaurant = restaurantRepo.findById(restaurantId).get();
			Set<Food> food = restaurant.getFoods();
			
			for(Food food1 : food)
			{
				restaurant.removeFood(food1);
				restaurantRepo.save(restaurant);
			}
					
			restaurantRepo.deleteById(restaurantId);
			return "Restaurant deleted successfully..";
		}
		else
		{
			return "Restaurant doesnt exists";
		}
	}

}
