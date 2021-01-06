package com.blz.onlineclaimregistartion.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blz.onlineclaimregistartion.dto.PolicyDTO;
import com.blz.onlineclaimregistartion.exceptions.PolicyException;
import com.blz.onlineclaimregistartion.exceptions.UserException;
import com.blz.onlineclaimregistartion.model.Policy;
import com.blz.onlineclaimregistartion.model.User;
import com.blz.onlineclaimregistartion.repository.PolicyRepository;
import com.blz.onlineclaimregistartion.repository.UserRepository;
import com.blz.onlineclaimregistartion.utility.JsonWebToken;

@Service
public class PolicyService implements IPolicyService {

	@Autowired
	private PolicyRepository policyRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Policy> getAllPolicies(String token) {
		return policyRepository.findAll();
	}

	@Override
	public Policy getPolicyById(String token, Long policyId) {
		return policyRepository.findById(policyId)
				.orElseThrow(() -> new PolicyException("Policy with " + policyId + " id doesn't exist"));
	}

	@Override
	public Policy createPolicy(String token, PolicyDTO policyDTO) {

		Long decodeToken = JsonWebToken.decodeToken(token);
		User user = userRepository.findById(decodeToken);
		if (user.getRoleCode() == "user") {
			throw new UserException("User Cannot create the policy!! ");
		}
		Policy policy = new Policy();
		BeanUtils.copyProperties(policyDTO, policy);
		return policyRepository.save(policy);
	}

	@Override
	public Policy updatePolicy(String token, Long policyId, PolicyDTO policyDTO) {
		Policy policy = this.getPolicyById(token, policyId);
		BeanUtils.copyProperties(policyDTO, policy);
		return policyRepository.save(policy);
	}

	@Override
	public void deletePolicy(String token, Long policyId) {
		Policy policy = this.getPolicyById(token, policyId);
		policyRepository.deleteById(policyId);
	}

	@Override
	public List<Policy> getAllPoliciesByUserId(String token) {
		Long userId = JsonWebToken.decodeToken(token);
		return policyRepository.getAllPoliciesRegisteredByUserId(userId);
	}

	@Override
	public Policy registerPolicyByUserId(String token, long policyNumber) {
		Long userId = JsonWebToken.decodeToken(token);
		Policy policy = policyRepository.findPolicyDetails(policyNumber);
		PolicyDTO policyDTO = new PolicyDTO();
		BeanUtils.copyProperties(policy, policyDTO);
		Policy policy2 = new Policy(policyDTO);
		User user = userRepository.findById(userId);
		policy2.setUser(user);
		return policyRepository.save(policy2);
	}

}
