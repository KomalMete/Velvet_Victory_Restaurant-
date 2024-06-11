package com.velvetvictory.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velvetvictory.dto.request.RestaurantsRequest;
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

}
