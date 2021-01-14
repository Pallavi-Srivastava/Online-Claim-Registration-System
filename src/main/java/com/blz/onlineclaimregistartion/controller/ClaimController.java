package com.blz.onlineclaimregistartion.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blz.onlineclaimregistartion.dto.ClaimDTO;
import com.blz.onlineclaimregistartion.dto.ResponseDTO;
import com.blz.onlineclaimregistartion.model.Claim;
import com.blz.onlineclaimregistartion.service.IClaimService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/onlineinsurancesystem")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ClaimController {

	@Autowired
	private IClaimService claimService;

	@ApiOperation("To make a claim")
	@PostMapping("/claim/create/{userPolicyNumber}")
	public ResponseEntity<ResponseDTO> createClaim( @RequestHeader String token,
							@PathVariable("userPolicyNumber") Long userPolicyNumber, @Valid @RequestBody ClaimDTO claimDTO) {
		Claim claim = claimService.createClaim(token, userPolicyNumber, claimDTO);
		ResponseDTO responseDTO = new ResponseDTO(200, "Claim Created Sucessfull", claim);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@ApiOperation("To View Claim By Id")
	@GetMapping("/claim/get/{claimNumber}")
	public ResponseEntity<ResponseDTO> viewClaimById(@RequestHeader String token,
													@PathVariable("claimNumber") Long claimNumber) {
		Claim claim = claimService.viewClaim(token, claimNumber);
		ResponseDTO responseDTO = new ResponseDTO(200, "View claim by claim number is successfull", claim);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@ApiOperation("To View All Claim")
	@GetMapping("/claim/get")
	public ResponseEntity<ResponseDTO> viewClaim(@RequestHeader String token) {
		System.out.println("token"+ token);
		List<Claim> claim = claimService.viewAllClaim(token);
		ResponseDTO responseDTO = new ResponseDTO(200, "List of cliams ", claim);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}
