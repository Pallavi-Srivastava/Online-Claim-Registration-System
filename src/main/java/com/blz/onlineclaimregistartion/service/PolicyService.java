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
		Long userId = JsonWebToken.decodeToken(token);
		if( userId != null ) {
			return policyRepository.findAll();	
		}
		return null;
	}

	@Override
	public Policy getPolicyById(String token, Long policyId) {
		Long userId = JsonWebToken.decodeToken(token);
		if(userId != null) {
			return policyRepository.findById(policyId)
									.orElseThrow(() -> new PolicyException("Policy with " + policyId + " id doesn't exist"));
		}
		return null;
	}

	@Override
	public Policy createPolicy(String token, PolicyDTO policyDTO) {
		Long userId = JsonWebToken.decodeToken(token);
		User user = userRepository.findById(userId);
		String userRolecode = user.getRoleCode();
		if(!userRolecode.equals("admin")) {
			throw new UserException("User/Agent Cannot create the policy!!");
		}
		Policy policy = new Policy(policyDTO, user);
		return policyRepository.save(policy);
	}

	@Override
	public Policy updatePolicy(String token, Long policyId, PolicyDTO policyDTO) {
		Long userId = JsonWebToken.decodeToken(token);
		User user = userRepository.findById(userId);
		String userRolecode = user.getRoleCode();
		if(!userRolecode.equals("admin")) {
				Policy policy = this.getPolicyById(token, policyId);
				policy.updatePolicy(policyDTO, user);
				return policyRepository.save(policy);
		}
		return null;
	}

	@Override
	public boolean deletePolicy(String token, Long policyId) {
		Long userId = JsonWebToken.decodeToken(token);
		User user = userRepository.findById(userId);
		String userRolecode = user.getRoleCode();
		if(userRolecode.equals("admin")) {
			this.getPolicyById(token, policyId);
			policyRepository.deleteById(policyId);
			return true;
		}
		return false;
	}

	@Override
	public List<Policy> getAllPoliciesByUserId(String token) {
		Long userId = JsonWebToken.decodeToken(token);
		return policyRepository.getAllPoliciesRegisteredByUserId(userId);
	}

	@Override
	public Policy registerPolicyByUserId(String token, long policyNumber) {
		Long userId = JsonWebToken.decodeToken(token);
		User user = userRepository.findById(userId); 
		Policy policy = policyRepository.findPolicyDetails(policyNumber);
		PolicyDTO policyDTO = new PolicyDTO();
		BeanUtils.copyProperties(policy, policyDTO);
		Policy policy2 = new Policy(policyDTO, user);
//		User user = userRepository.findById(userId);
		return policyRepository.save(policy2);
	}

}
