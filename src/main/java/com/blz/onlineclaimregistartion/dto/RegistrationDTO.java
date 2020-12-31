package com.blz.onlineclaimregistartion.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class RegistrationDTO {
	
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$", message="Employee name Invalid")
	@NotEmpty(message="User name cannot be null ")
	public String userName;
	
	@Pattern(regexp = "^(?=.*[@#$%^&+=])(?=.*[0-9])(?=.*[A-Z]).{8,}$", 
			message = "Password length should be 8, must be a combination of at least one uppercase, lowercase, special character and number")
	@NotEmpty(message="Password cannot be null ")
	public String password;
	
	@NotBlank
	public String roleCode;
}
