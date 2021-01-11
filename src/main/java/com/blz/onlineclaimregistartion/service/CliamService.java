package com.blz.onlineclaimregistartion.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blz.onlineclaimregistartion.dto.ClaimDTO;
import com.blz.onlineclaimregistartion.exceptions.ClaimException;
import com.blz.onlineclaimregistartion.exceptions.UserPolicyException;
import com.blz.onlineclaimregistartion.model.Claim;
import com.blz.onlineclaimregistartion.model.Policy;
import com.blz.onlineclaimregistartion.model.User;
import com.blz.onlineclaimregistartion.model.UserPolicy;
import com.blz.onlineclaimregistartion.repository.IClaimRepository;
import com.blz.onlineclaimregistartion.repository.PolicyRepository;
import com.blz.onlineclaimregistartion.repository.UserPolicyRepository;
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
	
	@Autowired
	private UserPolicyRepository userPolicyRepository;

	@Override
	public Claim createClaim(String token, Long userPolicyNumber, ClaimDTO claimDTO) {
		Long userId = JsonWebToken.decodeToken(token);
		UserPolicy userPolicy = userPolicyRepository.findById(userPolicyNumber)
													.orElseThrow(() -> new UserPolicyException("User Policy with " + userPolicyNumber + " id doesn't exist"));
		Claim claim = new Claim(claimDTO, userPolicy);
		return claimRepository.save(claim);
	}

	@Override
	public Claim viewClaim(String token, Long claimNumber) {
		Long userId = JsonWebToken.decodeToken(token);
		return claimRepository.findById(claimNumber)
									.orElseThrow(() -> new ClaimException("Claim with " + claimNumber + " id doesn't exist"));
	}

	@Override
	public List<Claim> viewAllClaim(String token) {
		return null;
	}

}
