package com.velvetvictory.dto.request;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.velvetvictory.models.FoodCategory;
import com.velvetvictory.models.Restaurants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FoodRequest {

	private Long id;
	
	private String name;
	
	private String discription;

	private double price;
	
	private FoodCategory foodCategory;
	
	private Set<Restaurants> restaurants;
}
