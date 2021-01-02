package com.blz.onlineclaimregistartion.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RestorePasswordDTO {

	@Pattern(regexp = "^([a-z0-9]+[-._+]?[a-z0-9]+)+@[a-z0-9-]+.[a-z]{2,3}.[a-z]{2,3}$", message = "Please enter a valid email")
	@NotEmpty(message = "Email can't be null ")
	public String email;
}
