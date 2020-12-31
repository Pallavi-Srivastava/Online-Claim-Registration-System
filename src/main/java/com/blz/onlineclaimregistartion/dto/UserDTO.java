package com.blz.onlineclaimregistartion.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class UserDTO {
	
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$", message="Employee name Invalid")
	@NotEmpty(message="User name cannot be null ")
	private String userName;

//	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,20}$",
//			message = "Password length should be 8 char, must contain at least one uppercase, lowercase, special character and number")
	@NotBlank
	private String password;
}
