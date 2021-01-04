package com.blz.onlineclaimregistartion.model;

import javax.persistence.ManyToOne;

import com.blz.onlineclaimregistartion.dto.PolicyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Policy {

	private Long policyId;
	private String policyName;
	private Double premium;
	
	public Policy(PolicyDTO policyDTO) {
		this.policyId = policyDTO.policyId;
		this.policyName = policyDTO.policyName;
		this.premium = policyDTO.premium;
	}
	
}
