package com.blz.onlineclaimregistartion.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@JsonIgnore
	@ManyToOne(targetEntity = Policy.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "policy_id_fk", referencedColumnName = "policy_id")
	private Policy policy;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_stamp")
	private Date createStamp;
}
