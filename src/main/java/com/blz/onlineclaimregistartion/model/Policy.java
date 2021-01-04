package com.blz.onlineclaimregistartion.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.blz.onlineclaimregistartion.dto.PolicyDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "policy_details")
@Data
public class Policy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "policy_id")
	private Long policyId;
	
	@Column(name = "policy_name", unique = true, nullable = false)
	private String policyName;
	
	@Column(nullable = false)
	private Double premium;
	
	@JsonIgnore
	@Column(nullable=false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate = LocalDateTime.now();
	
	public Policy() {}
	
	public Policy(PolicyDTO policyDTO) {
		this.updatePolicy(policyDTO);
	}

	public void updatePolicy(PolicyDTO policyDTO) {
		this.policyName = policyDTO.policyName;
		this.premium = policyDTO.premium;
	}	
}
