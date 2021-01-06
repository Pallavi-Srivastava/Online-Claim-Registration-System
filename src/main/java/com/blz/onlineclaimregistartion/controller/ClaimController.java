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

	@ApiOperation("To Create Claim")
	@PostMapping("/claim/create/{policyNumber}")
	public ResponseEntity<ResponseDTO> claim(@Valid @RequestBody ClaimDTO claimDTO,
			@PathVariable("policyNumber") long policyNumber, @RequestHeader String token) {
		Claim claim = claimService.createClaim(claimDTO, token, policyNumber);
		ResponseDTO responseDTO = new ResponseDTO(200, "Claim Created Sucessfull", claim);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@ApiOperation("To View Claim By Id")
	@GetMapping("/claim/viewbyid/{policyNumber}")
	public ResponseEntity<ResponseDTO> viewClaimById(@RequestHeader String token,
			@PathVariable("policyNumber") long policyNumber) {
		List<Claim> claim = claimService.viewClaim(token, policyNumber);
		ResponseDTO responseDTO = new ResponseDTO(200, "List of cliams ", claim);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@ApiOperation("To View All Claim")
	@GetMapping("/claims")
	public ResponseEntity<ResponseDTO> viewClaim(@RequestHeader String token) {
		List<Claim> claim = claimService.viewAllClaim(token);
		ResponseDTO responseDTO = new ResponseDTO(200, "List of cliams ", claim);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}
