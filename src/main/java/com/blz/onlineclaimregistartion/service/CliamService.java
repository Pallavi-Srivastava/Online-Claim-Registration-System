package com.blz.onlineclaimregistartion.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blz.onlineclaimregistartion.dto.ClaimDTO;
import com.blz.onlineclaimregistartion.model.Claim;
import com.blz.onlineclaimregistartion.model.Policy;
import com.blz.onlineclaimregistartion.model.User;
import com.blz.onlineclaimregistartion.repository.IClaimRepository;
import com.blz.onlineclaimregistartion.repository.PolicyRepository;
import com.blz.onlineclaimregistartion.repository.UserRepository;
import com.blz.onlineclaimregistartion.utility.JsonWebToken;

@Service
public class CliamService implements IClaimService {

	@Autowired
	private IClaimRepository claimRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PolicyRepository policyRepository;

//	@Override
//	public Claim createClaim(ClaimDTO claimDTO, String token, long policyNumber) {
//		Claim claim = new Claim();
//		BeanUtils.copyProperties(claimDTO, claim);
//		long userId = JsonWebToken.decodeToken(token);
//		Policy policy = policyRepository.findPolicyId(policyNumber, userId);
//		claim.setPolicy(policy);
//		return claimRepository.save(claim);
//	}
//
//	@Override
//	public List<Claim> viewClaim(String token, long policyNumber) {
//		Long userId = JsonWebToken.decodeToken(token);
//		User user = userRepository.findById(userId);
//		Policy policy = policyRepository.findPolicyId(policyNumber, user.getUserId());
//		List<Claim> claim = claimRepository.findClaimById(policy.getPolicyId());
//		return claim;
//	}
//
//	@Override
//	public List<Claim> viewAllClaim(String token) {
//		return claimRepository.findAll();
//	}

}
