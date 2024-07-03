package com.velvetvictory.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velvetvictory.dto.request.CartDTO;
import com.velvetvictory.models.Cart;
import com.velvetvictory.models.Customer;
import com.velvetvictory.repository.CartRepository;
import com.velvetvictory.repository.CustomerRepository;
import com.velvetvictory.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public Object addFoodToCart(CartDTO cartDTO)
	{
		Cart cart = new Cart();
		Customer customer = customerRepo.findByEmail(cartDTO.getCustomerEmail());
		
		cart.setId(cartDTO.getId());
		cart.setFoodId(cartDTO.getFoodId());
		cart.setFoodName(cartDTO.getFoodName());
		cart.setFoodPrice(cartDTO.getFoodPrice());
		cart.setFoodQuantity(cartDTO.getFoodQuantity());
		cart.setRestaurantId(cartDTO.getRestaurantId());
		cart.setCustomer(customer);
		
		cartRepo.save(cart);
		
		return "Food successfully added to cart..";
	}

	@Override
	public Object removeFoodFromCart(Long cartId) {
		
		if(cartRepo.existsById(cartId))
		{
			Cart cart = cartRepo.findById(cartId).get();
			cartRepo.deleteById(cartId);
			return "Food removed from cart...";
		}
		else
		{
			return "Cart Id not found..";
		}
	}

	@Override
	public Object getAllFoodItemsFromCart(String customerEmail)
	{
		Customer customer = customerRepo.findByEmail(customerEmail);
		
		List<Cart> cart = cartRepo.getCartByCustomerID(customer.getId());
		
		if(!cart.isEmpty())
		{
			return cart;
		}
		else
		{
			return " No Food item present in cart";
		}
		
	}

	@Override
	public Object increaseFoodQuantity(Long cartId, String customerEmail)
	{
		
		Cart cart = cartRepo.findById(cartId).orElseThrow(() -> new IllegalArgumentException("Cart not found for "+customerEmail));
		
		cart.setFoodQuantity(cart.getFoodQuantity()+1);
		cartRepo.save(cart);
		return " Food quantity increased successfully..";
	}

	@Override
	public Object decreaseFoodQuantity(Long cartId, String customerEmail) 
	{
		Cart cart = cartRepo.findById(cartId).orElseThrow(() -> new IllegalArgumentException("Cart not found for "+customerEmail));
		
		cart.setFoodQuantity(cart.getFoodQuantity()- 1);
		cartRepo.save(cart);
		return " Food quantity decreased successfully..";
	}

}
