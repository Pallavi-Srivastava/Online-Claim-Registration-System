package com.blz.onlineclaimregistartion.service;

import java.util.List;

import javax.validation.Valid;

import com.blz.onlineclaimregistartion.dto.ClaimDTO;
import com.blz.onlineclaimregistartion.model.Claim;

public interface IClaimService {

	Claim createClaim(@Valid ClaimDTO claimDTO, String token, long policyNumber);

	List<Claim> viewClaim(String token, long policyNumber);

	List<Claim> viewAllClaim(String token);

}
