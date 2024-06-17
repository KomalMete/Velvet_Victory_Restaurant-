package com.velvetvictory.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	@NotEmpty(message = "firstname cannot be empty")
	private String firstName;
	
	@Column(name = "last_name")
	@NotEmpty(message = "lastname cannot be empty")
	private String lastName;
	
	@Column(length = 10)
	@Size(min = 10,max = 10)
	private String contact;
	
	@Column(unique = true)
	@Email
	@NotEmpty(message = "email cannot be null")
	private String email;
	
	@Column(name = "password")
	@NotEmpty(message = "password required")
	private String password;
	
	@Column(length = 20)
	@NotEmpty
	private String role;


}
