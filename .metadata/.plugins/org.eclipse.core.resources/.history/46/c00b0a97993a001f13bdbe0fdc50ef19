package com.velvetvictory.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	
	@Column(name="total_price")
	private String totalPrice;
	
	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private Restaurants restaurant;
	
	@ManyToMany
	@JoinTable(
			name = "orders_food",
			joinColumns = @JoinColumn(name = "order_id"),
		    inverseJoinColumns = @JoinColumn(name = "food_id")
			)
	private List<Food> foods = new ArrayList<>();
	
	@OneToOne
	@Column(name="payment_id")
	private Payment paymentId;
	
	@Column(name="status")
	private String status;
	
}
