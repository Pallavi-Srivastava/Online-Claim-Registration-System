package com.blz.onlineclaimregistartion.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.blz.onlineclaimregistartion.dto.ClaimDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "claim")
@NoArgsConstructor
public class Claim {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "claim_number")
	private Long claimNumber;

	@Column(name = "claim_reason")
	private String claimReason;

	@Column(name = "street")
	private String street;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "zipcode")
	private String zipcode;

	@Column(name = "claim_type")
	private String claimType;

	@OneToOne(targetEntity = UserPolicy.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_user_policy_id", referencedColumnName = "user_policy_id", nullable = false, updatable = false)
	private UserPolicy userPolicy;

	@JsonIgnore
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate = LocalDateTime.now();

	public Claim(ClaimDTO claimDTO, UserPolicy userPolicy) {
		this.claimReason = claimDTO.getClaimReason();
		this.street = claimDTO.getStreet();
		this.city = claimDTO.getCity();
		this.state = claimDTO.getState();
		this.zipcode = claimDTO.getZipcode();
		this.claimType = claimDTO.getClaimType();
		this.userPolicy = userPolicy;
	}
		
}
