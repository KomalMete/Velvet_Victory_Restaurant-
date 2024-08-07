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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name = "address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "city")
	@NotEmpty(message = "city cannot be empty")
	private String city;
	
	@Column(name = "state")
	@NotEmpty(message = "state cannot be empty")
	private String state;
	
	@Column(name = "pincode")
	@NotEmpty(message = "pincode cannot be empty")
	private String pincode;
	
	@Column(name = "address")
	@NotEmpty(message = "address cannot be empty")
	private String address;
	
	@Column(name = "landmark")
	@NotEmpty(message = "landmark cannot be empty")
	private String landmark;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
}
