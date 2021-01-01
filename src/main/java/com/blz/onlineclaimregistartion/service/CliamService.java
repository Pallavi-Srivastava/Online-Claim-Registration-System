package com.blz.onlineclaimregistartion.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blz.onlineclaimregistartion.dto.ClaimDTO;
import com.blz.onlineclaimregistartion.model.Claim;
import com.blz.onlineclaimregistartion.model.User;
import com.blz.onlineclaimregistartion.repository.IClaimRepository;
import com.blz.onlineclaimregistartion.repository.UserRepository;
import com.blz.onlineclaimregistartion.utility.JsonWebToken;

@Service
public class CliamService implements IClaimService {

	@Autowired
	private IClaimRepository claimRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Claim createClaim(ClaimDTO claimDTO) {
		Claim claim = new Claim();
		BeanUtils.copyProperties(claimDTO, claim);
		return claimRepository.save(claim);
	}

	@Override
	public List<Claim> viewClaim(String token) {
		Long userId = JsonWebToken.decodeToken(token);
		User user = userRepository.findById(userId);
		return null;
	}

	@Override
	public List<Claim> viewAllClaim(String token) {
		return claimRepository.findAll();
	}

}
