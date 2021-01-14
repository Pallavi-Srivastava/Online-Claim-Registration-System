package com.blz.onlineclaimregistartion.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import org.hibernate.annotations.CreationTimestamp;

import com.blz.onlineclaimregistartion.dto.RegistrationDTO;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_role", uniqueConstraints = { @UniqueConstraint(columnNames = "user_name"),
		@UniqueConstraint(columnNames = "email") })
@Data
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "role_code")
	public String roleCode;

	@Column(name = "account_number")
	public Long accountNumber;
	
	@Email
	@Column(name = "email")
	private String email;// To reset/forget password
	
	@Column(name= "created_by")
	private long createdBy;  
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_stamp")
	private Date createStamp;// To Identify Complete User registration Information

	@Column(name = "login_attempt")
	private int loginAttempt;// To identify no. of logIn attempt

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login")
	private Date lastLogin;// To identify Last User Login

	@Column(name = "inactive_user")
	private boolean inactiveUser;// It's used to identify user state active/inActive
	
	public User(RegistrationDTO registrationDTO, long userId) {
		this.userName = registrationDTO.userName;
		this.password = registrationDTO.password;
		this.roleCode = registrationDTO.roleCode;
		this.email = registrationDTO.email;
		this.createdBy=userId;	
	}
}

