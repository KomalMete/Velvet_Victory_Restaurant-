package com.velvetvictory.dto.request;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.velvetvictory.models.FoodCategory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@ToString
public class FoodRequest {

	private Long id;
	
	private String name;
	
	private String discription;

	private double price;
	
	private String image;
	
	private FoodCategory foodCategory;
}
