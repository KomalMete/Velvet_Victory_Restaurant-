package com.velvetvictory.dto.request;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.velvetvictory.models.Customer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class CartDTO {

	private Long id;

	private Long foodId;

	private String foodName;

	private double foodPrice;

	private int foodQuantity;

	private Long restaurantId;

	private String customerEmail;
	
}
