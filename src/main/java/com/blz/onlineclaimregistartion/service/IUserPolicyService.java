package com.blz.onlineclaimregistartion.service;

import java.util.List;

import com.blz.onlineclaimregistartion.model.Policy;

public interface IUserPolicyService {

	Policy registerPolicy(String token, Long PolicyId);
	
	List<String> getRegistredPolicies(String token);
	
//	List<Object> getRegistredPolicies(String token); 
	
}
