package com.velvetvictory.service;

import com.velvetvictory.dto.request.CartDTO;

public interface CartService {

	Object addFoodToCart(CartDTO cartDTO);

	Object removeFoodFromCart(Long cartId);

	Object getAllFoodItemsFromCart(String customerEmail);

	Object increaseFoodQuantity(Long cartId);

	Object decreaseFoodQuantity(Long cartId);

}
