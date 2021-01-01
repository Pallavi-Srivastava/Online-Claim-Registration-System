package com.blz.onlineclaimregistartion.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blz.onlineclaimregistartion.service.IUserService;
import io.swagger.annotations.ApiOperation;
import com.blz.onlineclaimregistartion.dto.RegistrationDTO;
import com.blz.onlineclaimregistartion.dto.ResponseDTO;
import com.blz.onlineclaimregistartion.dto.UserDTO;
import com.blz.onlineclaimregistartion.exceptions.UserException;
import com.blz.onlineclaimregistartion.model.User;

@RestController
@RequestMapping("/onlineinsurancesystem")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {

	@Autowired
	private IUserService userService;

	@ApiOperation("For registration")
	@PostMapping("/register")
	public ResponseEntity<ResponseDTO> register(@Valid @RequestBody RegistrationDTO registrationDto) {
		if (userService.register(registrationDto) != null)
			return new ResponseEntity<>(new ResponseDTO("Your account has been successfully created", registrationDto),
					HttpStatus.OK);
		return new ResponseEntity<>(new ResponseDTO("user registration unsuccessful"), HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/login")
	@ApiOperation("For Login")
	public ResponseEntity<ResponseDTO> login(@Valid @RequestBody UserDTO userDTO) {
		String token = userService.login(userDTO);
		if (token != null) {
			return new ResponseEntity<>(new ResponseDTO("User login successful", token), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ResponseDTO("User login unsuccessful"), HttpStatus.NOT_ACCEPTABLE);
	}
}
