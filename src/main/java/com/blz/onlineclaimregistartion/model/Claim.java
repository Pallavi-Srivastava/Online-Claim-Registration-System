package com.blz.onlineclaimregistartion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "claim")
public class Claim {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "claim_number")
	private long claimNumber;

	@Column(name = "claim_resion")
	private String claimReason;

	@Column(name = "street")
	private String accidentLocationStreet;

	@Column(name = "city")
	private String accidentCity;

	@Column(name = "state")
	private String accidentState;

	@Column(name = "zip")
	private String accidentZip;

	@Column(name = "claim_type")
	private String claimType;

	@Column(name = "policy_number")
	private long policyNumber;
}
