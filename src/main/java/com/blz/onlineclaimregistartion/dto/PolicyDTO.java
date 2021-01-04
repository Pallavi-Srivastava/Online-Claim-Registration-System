package com.blz.onlineclaimregistartion.dto;

import javax.validation.constraints.NotBlank;

import lombok.ToString;

@ToString
public class PolicyDTO {
	
	@NotBlank(message = "Policy name can't be empty")
	public String policyName;
	
	public double premium;
}
