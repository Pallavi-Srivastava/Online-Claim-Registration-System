package com.blz.onlineclaimregistartion.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ClaimDTO {

	@NotBlank(message = "Claim Reason cannot be blank")
	private String claimReason;

	@NotBlank(message = "Accident Location Street cannot be blank")
	private String street;

	@NotBlank(message = "City cannot be blank")
	private String city;

	@NotBlank(message = "State cannot be blank")
	private String state;

	@NotBlank(message = "Zipcode cannot be blank")
	private String zipcode;

	@NotBlank(message = "Claim Type cannot be blank")
	private String claimType;

}
