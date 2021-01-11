package com.blz.onlineclaimregistartion.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "claim")
public class Claim {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "claim_number")
	private long claimNumber;

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
	@JoinColumn(name = "userPolicyId", referencedColumnName = "user_policy_id", nullable = false, updatable = false)
	private UserPolicy userPolicy;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_stamp")
	private Date createStamp;
	
}
