package com.blz.onlineclaimregistartion.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	@PostMapping("/createclaim")
	public ResponseEntity<ResponseDTO> claim(@Valid @RequestBody ClaimDTO claimDTO) {
		Claim claim = claimService.createClaim(claimDTO);
		ResponseDTO responseDTO = new ResponseDTO("Claim Created Sucessfull",claim);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@ApiOperation("To View Claim")
	@GetMapping("/viewclaim")
	public ResponseEntity<ResponseDTO> viewClaimById(@RequestHeader String token){
		List<Claim> claim=claimService.viewClaim(token);
		ResponseDTO responseDTO = new ResponseDTO("List of cliams ", claim);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@ApiOperation("To All View Claim")
	@GetMapping("/viewallclaims")
	public ResponseEntity<ResponseDTO> viewClaim(@RequestHeader String token){
		List<Claim> claim=claimService.viewAllClaim(token);
		ResponseDTO responseDTO = new ResponseDTO("List of cliams ", claim);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
}













