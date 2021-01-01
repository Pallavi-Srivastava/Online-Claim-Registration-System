package com.blz.onlineclaimregistartion.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.blz.onlineclaimregistartion.dto.PolicyDTO;
import com.blz.onlineclaimregistartion.model.Policy;

@Service
public class PolicyService implements IPolicyService {

	List<Policy> policies = new ArrayList<>();
	
	@Override
	public List<Policy> getAllPolicies(String token) {
		policies.add(new Policy(1, 50000.0));
		policies.add(new Policy(2, 100000.0));
		return policies;
	}

	@Override
	public Policy getPolicyById(String token, int policyId) {
		return policies.get(policyId-1);
	}

	@Override
	public Policy createPolicy(String token, PolicyDTO policyDTO) {
		Policy policy = new Policy(policyDTO);
		policies.add(policy);
		return policy;
	}

	@Override
	public Policy updatePolicy(String token, int policyId, PolicyDTO policyDTO) {
		return policies.set(policyId, new Policy(policyDTO));
	}

	@Override
	public void deletePolicy(String token, int policyId) {
		policies.remove(policyId-1);
	}

	@Override
	public List<Policy> getAllPoliciesByUserId(String token) {
		policies.add(new Policy(1, 50000.0));
		policies.add(new Policy(2, 100000.0));
		return policies;
	}

}
