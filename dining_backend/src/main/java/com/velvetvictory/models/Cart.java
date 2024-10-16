package com.velvetvictory.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 
	@Column(name = "food_id")
	@NotNull(message = "Food ID cannot be null")
	private Long foodId;
	
	@Column(name = "food_name")
	@NotEmpty(message = "Food Name cannot be empty")
	private String foodName;
	
	@Column(name = "food_price")
	@NotNull(message = "Food Price cannot be null")
	private double foodPrice;
	
	@Column(name = "food_quantity")
	@NotNull(message = "Food Quantity cannot be null")
	private int foodQuantity;
	
	@Column(name = "restaurant_id")
	@NotNull(message = "Restaurant ID cannot be null")
	private Long restaurantId;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
		
}
