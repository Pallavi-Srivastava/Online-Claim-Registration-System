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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "User_policy")
@Data
@NoArgsConstructor
public class UserPolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_policy_id")
	private Long userPolicyId;
	
	@ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_userid", referencedColumnName = "user_id", nullable = false, updatable = false)
	private User user;
	
	@ManyToOne(targetEntity = Policy.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_policyId", referencedColumnName = "policy_id", nullable = false, updatable = false)
	private Policy policy;
	
	@JsonIgnore
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate = LocalDateTime.now();

	public UserPolicy(User user, Policy policy) {
		this.user = user;
		this.policy = policy;
	}

}
