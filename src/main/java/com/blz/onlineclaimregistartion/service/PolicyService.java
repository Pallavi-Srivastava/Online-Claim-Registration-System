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
		policies.add(new Policy(1l, "GLI", 50000.0));
		policies.add(new Policy(2l, "BPI", 100000.0));
		return policies;
	}

	@Override
	public Policy getPolicyById(String token, Long policyId) {
		return policies.get((int)(policyId-1));
	}

	@Override
	public Policy createPolicy(String token, PolicyDTO policyDTO) {
		Policy policy = new Policy(policyDTO);
		policies.add(policy);
		return policy;
	}

	@Override
	public Policy updatePolicy(String token, Long policyId, PolicyDTO policyDTO) {
		return policies.set( (int)(policyId-1), new Policy(policyDTO));
	}

	@Override
	public void deletePolicy(String token, Long policyId) {
		policies.remove((int)(policyId-1));
	}

	@Override
	public List<Policy> getAllPoliciesByUserId(String token) {
		return policies;
	}

	@Override
	public Policy registerPolicyByUserId(String token, Long policyId) {
		return null;
	}

}
