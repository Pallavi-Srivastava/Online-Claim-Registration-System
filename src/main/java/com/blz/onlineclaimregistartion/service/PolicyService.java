package com.blz.onlineclaimregistartion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.blz.onlineclaimregistartion.dto.PolicyDTO;
import com.blz.onlineclaimregistartion.exceptions.PolicyException;
import com.blz.onlineclaimregistartion.model.Policy;
import com.blz.onlineclaimregistartion.repository.PolicyRepository;

@Service
public class PolicyService implements IPolicyService {

	@Autowired
	private PolicyRepository policyRepository;

	@Override
	public List<Policy> getAllPolicies(String token) {
		return policyRepository.findAll();
	}

	@Override
	public Policy getPolicyById(String token, Long policyId) {
		return policyRepository.findById(policyId)
									.orElseThrow(() -> new PolicyException("Policy with "+ policyId +" id doesn't exist"));
	}

	@Override
	public Policy createPolicy(String token, PolicyDTO policyDTO) {
		Policy policy = new Policy(policyDTO);
		return policyRepository.save(policy);
	}

	@Override
	public Policy updatePolicy(String token, Long policyId, PolicyDTO policyDTO) {
		Policy policy = this.getPolicyById(token, policyId);
		policy.updatePolicy(policyDTO);
		return policyRepository.save(policy);
	}

	@Override
	public void deletePolicy(String token, Long policyId) {
		Policy policy = this.getPolicyById(token, policyId);
		policyRepository.delete(policy);
	}

	@Override
	public List<Policy> getAllPoliciesByUserId(String token) {
		return null;
	}

	@Override
	public Policy registerPolicyByUserId(String token, Long policyId) {
		return null;
	}

}
