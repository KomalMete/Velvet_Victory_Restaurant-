package com.velvetvictory.dto.request;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.velvetvictory.models.FoodCategory;

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
public class FoodDTO {

	private Long id;
	
	private String name;
	
	private String discription;
	
	private double price;
	
	private String image;
	
}
