package com.blz.onlineclaimregistartion.dto;

import javax.validation.constraints.NotBlank;

import lombok.ToString;

@ToString
public class PolicyDTO {
	
	public long policyId;
	
	@NotBlank(message = "Policy name can't be empty")
	public String policyName;
	
	public double premium;
}
