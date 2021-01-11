package com.blz.onlineclaimregistartion.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ClaimDTO {

	@NotNull(message = "Claim Reason cannot be null")
	private String claimReason;

	@NotNull(message = "Accident Location Street cannot be null")
	private String street;

	@NotEmpty(message = "City cannot be null ")
	private String city;

	@NotNull(message = "State cannot be null ")
	private String state;

	@NotNull(message = "Zip cannot be null ")
	private String zipcode;

	@NotNull(message = "Claim Type cannot be null ")
	private String claimType;

}
