package com.blz.onlineclaimregistartion.model;

import com.blz.onlineclaimregistartion.dto.PolicyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Policy {

	private long id;
	private double premium;
	
	public Policy(PolicyDTO policyDTO) {
		this.id = policyDTO.id;
		this.premium = policyDTO.premium;
	}
}
