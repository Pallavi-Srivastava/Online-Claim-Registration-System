package com.blz.onlineclaimregistartion.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ClaimDTO {
	
	@NotNull(message = "Claim Reason cannot be null")
	private String claimReason;
	
	@NotNull(message = "Accident Location Street cannot be null")
	private String accidentLocationStreet;
	
	@NotEmpty(message = "City cannot be null ")
	private String accidentCity;
	
	@NotNull(message = "State cannot be null ")
	private String accidentState;
	
	@NotNull(message = "Zip cannot be null ")
	private String accidentZip;
	
	@NotNull(message = "Claim Type cannot be null ")
	private String claimType;
	
	@NotNull(message = "Policy Number cannot be null")
	private String policyNumber;
	
	
}
