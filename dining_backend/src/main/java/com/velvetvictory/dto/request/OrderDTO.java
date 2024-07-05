package com.velvetvictory.dto.request;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.velvetvictory.models.Address;
import com.velvetvictory.models.Customer;
import com.velvetvictory.models.Food;
import com.velvetvictory.models.Payment;
import com.velvetvictory.models.Restaurants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class OrderDTO {

	private Long orderId;

	private String totalPrice;

	private Address address;

	private Customer customer;

	private Restaurants restaurant;
	
	private List<Food> foods = new ArrayList<>();
	
	private Payment paymentId;
	
	private String status;
}
