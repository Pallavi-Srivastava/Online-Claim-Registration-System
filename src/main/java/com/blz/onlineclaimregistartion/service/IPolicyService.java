package com.blz.onlineclaimregistartion.service;

import java.util.List;

import com.blz.onlineclaimregistartion.dto.PolicyDTO;
import com.blz.onlineclaimregistartion.model.Policy;

public interface IPolicyService {

	List<Policy> getAllPolicies(String token);

	Policy getPolicyById(String token, Long policyId);

	Policy createPolicy(String token, PolicyDTO policyDTO);

	Policy updatePolicy(String token, Long policyId, PolicyDTO policyDTO);

	boolean deletePolicy(String token, Long policyId);
}
