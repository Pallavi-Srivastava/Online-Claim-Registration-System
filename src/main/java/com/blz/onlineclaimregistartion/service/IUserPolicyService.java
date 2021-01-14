package com.blz.onlineclaimregistartion.service;

import java.util.List;

import com.blz.onlineclaimregistartion.model.Policy;
import com.blz.onlineclaimregistartion.model.UserPolicy;

public interface IUserPolicyService {

	Policy registerPolicy(String token, Long PolicyId);
	
	List<UserPolicy> getRegistredPolicies(String token);
	
}
