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
public class ChangePasswordDTO {

	private String email;
	
	private String oldPassword;
	
	private String newPassword;
}
