package com.blz.onlineclaimregistartion.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ResetPasswordDTO {

	@Pattern(regexp = "^([a-z0-9]+[-._+]?[a-z0-9]+)+@[a-z0-9-]+.[a-z]{2,3}.[a-z]{2,3}$", message = "Please enter a valid email")
	@NotEmpty(message = "Email can't be null ")
	public String email;

	@Pattern(regexp = "^(?=.*[@#$%^&+=])(?=.*[0-9])(?=.*[A-Z]).{8,}$", message = "Invalid Pattern")
	@NotEmpty(message = "newPassword can't be null ")
	public String newPassword;

	@NotEmpty(message = "confirmPassword can't be null ")
	public String confirmPassword;

}
