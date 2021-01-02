package com.blz.onlineclaimregistartion.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blz.onlineclaimregistartion.service.IUserService;
import io.swagger.annotations.ApiOperation;
import com.blz.onlineclaimregistartion.dto.RegistrationDTO;
import com.blz.onlineclaimregistartion.dto.ResetPasswordDTO;
import com.blz.onlineclaimregistartion.dto.RestorePasswordDTO;
import com.blz.onlineclaimregistartion.dto.ResponseDTO;
import com.blz.onlineclaimregistartion.dto.UserDTO;
import com.blz.onlineclaimregistartion.model.User;

@RestController
@RequestMapping("/onlineinsurancesystem")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {

	@Autowired
	private IUserService userService;

	@ApiOperation("For registration")
	@PostMapping("/user/register")
	public ResponseEntity<ResponseDTO> register(@Valid @RequestBody RegistrationDTO registrationDto) {
		User user = (userService.register(registrationDto));
		return new ResponseEntity<>(new ResponseDTO(200, "Your account has been successfully created", user),
				HttpStatus.OK);
	}

	@ApiOperation("For login")
	@PostMapping("/user/login")
	public ResponseEntity<ResponseDTO> login(@Valid @RequestBody UserDTO userDTO) {
		String token = userService.login(userDTO);
		return new ResponseEntity<>(new ResponseDTO(200, "Login Successful", token), HttpStatus.OK);
	}

	@ApiOperation("For passwordRecovery")
	@PostMapping("/user/recovery")
	public ResponseEntity<ResponseDTO> recovery(@Valid @RequestBody RestorePasswordDTO restorePasswordDTO) {
		String password = userService.restorePassword(restorePasswordDTO);
		return new ResponseEntity<>(new ResponseDTO(200, "Your password has been recover successfully", password),
				HttpStatus.OK);
	}

	@ApiOperation("For passwordReset")
	@PostMapping("/user/reset")
	public ResponseEntity<ResponseDTO> reset(@Valid @RequestBody ResetPasswordDTO resetPasswordDTO) {
		User user = userService.resetPassword(resetPasswordDTO);
		return new ResponseEntity<>(new ResponseDTO(200, "Your password has been reset successfully", user),
				HttpStatus.OK);
	}
}
