package com.velvetvictory.dto.request;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.velvetvictory.models.Address;
import com.velvetvictory.models.Customer;
import com.velvetvictory.models.Food;
import com.velvetvictory.models.Payment;
import com.velvetvictory.models.PaymentMode;
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
public class PaymentDTO {

	private Long id;
	
	private PaymentMode paymentMode;
}
