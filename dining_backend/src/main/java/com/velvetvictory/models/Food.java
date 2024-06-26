package com.velvetvictory.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "food")
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "food_name")
	private String name;
	
	@Column(name = "food_discription")
	private String discription;
	
	@Column(name = "food_price")
	private double price;
	
	@Column(name = "image")
	@NotEmpty(message = "Image cant be null")
	private String image;
	
	@ManyToOne
	@JoinColumn(name = "foodCategory_id")
	private FoodCategory foodCategory;
	
	@ManyToMany(mappedBy = "foods")
	private Set<Restaurants> restaurants = new HashSet<>();
	
	 public void addRestaurants(Restaurants restaurant) {
	        restaurants.add(restaurant);
	        restaurant.getFoods().add(this);
	    }

	    public void removeRestaurant(Restaurants restaurant) {
	        restaurants.remove(restaurant);
	        restaurant.getFoods().remove(this);
	    }
}
