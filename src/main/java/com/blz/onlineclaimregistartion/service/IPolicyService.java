package com.blz.onlineclaimregistartion.service;

import java.util.List;

import com.blz.onlineclaimregistartion.dto.PolicyDTO;
import com.blz.onlineclaimregistartion.model.Policy;

public interface IPolicyService {

    List<Policy> getAllPolicies(String token);

    Policy getPolicyById(String token, int policyId);

    Policy createPolicy(String token, PolicyDTO policyDTO);

    Policy updatePolicy(String token, int policyId, PolicyDTO policyDTO);

    void deletePolicy(String token, int policyId);
    
    List<Policy> getAllPoliciesByUserId(String token);
}
