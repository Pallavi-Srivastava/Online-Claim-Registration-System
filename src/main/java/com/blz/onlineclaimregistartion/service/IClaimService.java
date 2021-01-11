package com.blz.onlineclaimregistartion.service;

import java.util.List;

import javax.validation.Valid;

import com.blz.onlineclaimregistartion.dto.ClaimDTO;
import com.blz.onlineclaimregistartion.model.Claim;

public interface IClaimService {

	Claim createClaim(String token, Long policyNumber, @Valid ClaimDTO claimDTO);

	List<Claim> viewClaim(String token, Long policyNumber);

	List<Claim> viewAllClaim(String token);

}
