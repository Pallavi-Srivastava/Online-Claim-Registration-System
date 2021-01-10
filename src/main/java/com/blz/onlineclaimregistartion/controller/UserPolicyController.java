package com.blz.onlineclaimregistartion.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blz.onlineclaimregistartion.dto.ResponseDTO;
import com.blz.onlineclaimregistartion.model.Policy;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/onlineinsurancesystem")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserPolicyController {

	@ApiOperation("To register policy for a user")
	@PostMapping("/userpolicy/register/{policyId}")
	public ResponseEntity<ResponseDTO> registerPolicy(@RequestHeader String token, @PathVariable("policyId") Long policyId) {
		ResponseDTO responseDTO = new ResponseDTO(200, "Policy registered successfully", policyId);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	@ApiOperation("To get policies of user")
	@GetMapping("/userpolicy/get")
	public ResponseEntity<ResponseDTO> getPoliciesByUserId(@RequestHeader String token) {
		List<Policy> policies = new ArrayList<>();
		ResponseDTO responseDTO = new ResponseDTO(200, "User policies", policies);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

}
