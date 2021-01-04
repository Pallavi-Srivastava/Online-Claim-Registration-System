package com.blz.onlineclaimregistartion.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ResetPasswordDTO {

	@Pattern(regexp = "^(?=.*[@#$%^&+=])(?=.*[0-9])(?=.*[A-Z]).{8,}$", message = "Invalid Pattern")
	@NotEmpty(message = "newPassword can't be null ")
	public String newPassword;

	@NotEmpty(message = "confirmPassword can't be null ")
	public String confirmPassword;

}
