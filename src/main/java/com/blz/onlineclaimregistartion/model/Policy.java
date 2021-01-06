package com.blz.onlineclaimregistartion.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	@Column(name = "policy_number")
	private long policyNumber;

	@Column(name = "policy_name")
	private String policyName;

	@Column(nullable = false)
	private Double premium;

	@JsonIgnore
	@ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id_fk", referencedColumnName = "user_id")
	private User user;

	@JsonIgnore
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate = LocalDateTime.now();

	public Policy(PolicyDTO policyDTO) {
		this.updatePolicy(policyDTO);
	}

	public void updatePolicy(PolicyDTO policyDTO) {
		this.policyNumber = policyDTO.policyNumber;
		this.policyName = policyDTO.policyName;
		this.premium = policyDTO.premium;
	}

}
