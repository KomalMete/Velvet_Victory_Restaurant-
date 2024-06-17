package com.velvetvictory.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name = "restaurants")
public class Restaurants {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "restaurant_name")
	@NotEmpty(message = "Restaurant Name cannot be empty")
	private String restaurantName;
	
	@ManyToMany
	@JoinTable(
			name = "restaurants_food",
			joinColumns = @JoinColumn(name = "restaurant_id"),
			inverseJoinColumns = @JoinColumn(name = "food_id"))
	private Set<Food> foods;
	
	public void addFood(Food food) {
        this.foods.add(food);
        food.getRestaurants().add(this);
    }

    public void removeFood(Food food) {
        this.foods.remove(food);
        food.getRestaurants().remove(this);
    }
}
