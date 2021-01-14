package com.blz.onlineclaimregistartion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.blz.onlineclaimregistartion.model.UserPolicy;
import com.blz.onlineclaimregistartion.service.IUserPolicyService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/onlineinsurancesystem")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserPolicyController {
	
	@Autowired
	private IUserPolicyService userPolicyService;

	@ApiOperation("To register policy for a user")
	@PostMapping("/userpolicy/register/{policyId}")
	public ResponseEntity<ResponseDTO> registerPolicy( @PathVariable("policyId") Long policyId, @RequestHeader String token) {
		Policy policy = userPolicyService.registerPolicy(token, policyId);
		if(policy != null) {
			ResponseDTO responseDTO = new ResponseDTO(200, "Successfully registered for policy", policyId);
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
		}
		ResponseDTO responseDTO = new ResponseDTO(400, "Faild to register for policy", policyId);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	
	@ApiOperation("To get policies of user")
	@GetMapping("/userpolicy/get")
	public ResponseEntity<ResponseDTO> getPoliciesByUserId(@RequestHeader String token) {
		List<UserPolicy> userInsuredPolicies = userPolicyService.getRegistredPolicies(token);
		ResponseDTO responseDTO = new ResponseDTO(200, "User policies", userInsuredPolicies);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

}
