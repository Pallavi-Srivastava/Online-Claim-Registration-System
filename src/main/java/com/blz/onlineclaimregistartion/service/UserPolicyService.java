package com.blz.onlineclaimregistartion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blz.onlineclaimregistartion.exceptions.PolicyException;
import com.blz.onlineclaimregistartion.model.Policy;
import com.blz.onlineclaimregistartion.model.User;
import com.blz.onlineclaimregistartion.model.UserPolicy;
import com.blz.onlineclaimregistartion.repository.PolicyRepository;
import com.blz.onlineclaimregistartion.repository.UserPolicyRepository;
import com.blz.onlineclaimregistartion.repository.UserRepository;
import com.blz.onlineclaimregistartion.utility.JsonWebToken;

@Service
public class UserPolicyService implements IUserPolicyService {
	
	@Autowired
	private UserPolicyRepository userPolicyRepository;
	
	@Autowired
	private PolicyRepository policyRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Policy registerPolicy(String token, Long policyId) {
		Long userId = JsonWebToken.decodeToken(token);
		User user = userRepository.findById(userId);
		Policy policy = policyRepository.findById(policyId)
										.orElseThrow(() -> new PolicyException("Policy with " + policyId + " id doesn't exist")); 
		UserPolicy userPolicy = new UserPolicy(user, policy);
		userPolicy = userPolicyRepository.save(userPolicy);
		if(userPolicy != null) {
			return policy;
		}
		return null;
	}

	@Override
	public List<UserPolicy> getRegistredPolicies(String token) {
		Long userId = JsonWebToken.decodeToken(token);
		User user = userRepository.findById(userId);
		String userRolecode = user.getRoleCode();
		if (userRolecode.equals("user")) {
			List<UserPolicy> userInsuredPlocies = userPolicyRepository.findAllUserPoliciesByuserId(userId);
			return userInsuredPlocies;
		} else if (userRolecode.equals("agent")) {
			return userPolicyRepository.findAllUserPoliciesByRoleCodeAgent(userId);
		}
		return userPolicyRepository.findAllUserPoliciesByAdmin();
	}

}
