package com.blz.onlineclaimregistartion.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.blz.onlineclaimregistartion.dto.PolicyDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "policy_details")
@Data
@NoArgsConstructor
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "policy_id")
	private Long policyId;

	@Column(name = "policy_name", nullable = false, unique = true)
	private String policyName;

	@Column(nullable = false)
	private Double premium;

	@JsonIgnore
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate = LocalDateTime.now();
	
	@JsonIgnore
	@ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "created_userid", referencedColumnName = "user_id", nullable = false, updatable = false)
	private User createdUser;

	public Policy(PolicyDTO policyDTO, User user) {
		this.updatePolicy(policyDTO, user);
	}

	public void updatePolicy(PolicyDTO policyDTO, User user) {
		this.policyName = policyDTO.policyName;
		this.premium = policyDTO.premium;
		this.createdUser = user;
	}

}
