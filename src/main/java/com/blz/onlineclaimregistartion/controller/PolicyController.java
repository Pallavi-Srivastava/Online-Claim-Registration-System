package com.blz.onlineclaimregistartion.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blz.onlineclaimregistartion.dto.PolicyDTO;
import com.blz.onlineclaimregistartion.dto.ResponseDTO;
import com.blz.onlineclaimregistartion.model.Policy;
import com.blz.onlineclaimregistartion.service.IPolicyService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/onlineinsurancesystem")
@CrossOrigin(allowedHeaders = "*", origins = "*")
@Slf4j
public class PolicyController {
	
	@Autowired
	private IPolicyService policyService;
	
	@ApiOperation("To create the new policy")
	@PostMapping("/policy/create")
	public ResponseEntity<ResponseDTO> createPolicy(@RequestHeader String token, @Valid @RequestBody PolicyDTO policyDTO) {
		Policy policy = policyService.createPolicy(token, policyDTO); 
		ResponseDTO responseDTO = new ResponseDTO(200, "New policy created successfully", policy);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	@ApiOperation("To get all policy available for insurance")
	@GetMapping("/policy")
	public ResponseEntity<ResponseDTO> getAllPolicies(@RequestHeader String token) {
		List<Policy> policies = policyService.getAllPolicies(token); 
		ResponseDTO responseDTO = new ResponseDTO(200, "All existing policies", policies);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	@ApiOperation("To get policy by policyId")
	@GetMapping("/policy/{policyId}")
	public ResponseEntity<ResponseDTO> getPolicyByPolicyId(@RequestHeader String token, @PathVariable Long policyId) {
		Policy policy = policyService.getPolicyById(token, policyId);
		ResponseDTO responseDTO = new ResponseDTO(200, "Policy with id:"+ policyId, policy);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	@ApiOperation("To update policy")
	@PutMapping("/policy/update/{policyId}")
	public ResponseEntity<ResponseDTO> updatePolicy(@RequestHeader String token, @PathVariable Long policyId,@Valid @RequestBody PolicyDTO policyDTO) {
		Policy policy = policyService.updatePolicy(token, policyId, policyDTO);
		ResponseDTO responseDTO = new ResponseDTO(200, "Policy updated successfully ", policy);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@ApiOperation("To delete a policy")
	@DeleteMapping("/policy/delete/{policyId}")
	public ResponseEntity<ResponseDTO> deletePolicy(@RequestHeader String token, @PathVariable Long policyId) {
		policyService.deletePolicy(token, policyId);
		ResponseDTO responseDTO = new ResponseDTO(200, "Policy deleted successfully", "Deleted policy with id:"+ policyId);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	@ApiOperation("To get policies of user")
	@GetMapping("/policy/user")
	public ResponseEntity<ResponseDTO> getPoliciesByUserId(@RequestHeader String token) {
		List<Policy> policies = policyService.getAllPoliciesByUserId(token); 
		ResponseDTO responseDTO = new ResponseDTO(200, "User policies", policies);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	@ApiOperation("To register policy for a user")
	@PostMapping("/policy/user/register/{policyId}")
	public ResponseEntity<ResponseDTO> registerPolicy(@RequestHeader String token, Long policyId) {
		Policy policy = policyService.registerPolicyByUserId(token, policyId); 
		ResponseDTO responseDTO = new ResponseDTO(200, "User policies", policy);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}	
}
