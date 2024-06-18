package com.velvetvictory.dto.request;

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
public class AdminRequest {

	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String contact;
	
	private String email;

	private String password;

	private String role;
}
