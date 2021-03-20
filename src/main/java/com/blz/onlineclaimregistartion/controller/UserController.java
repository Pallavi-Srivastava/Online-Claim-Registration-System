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
import com.blz.onlineclaimregistartion.service.IUserService;
import com.blz.onlineclaimregistartion.dto.ForgotPasswordDTO;
import com.blz.onlineclaimregistartion.dto.LogInResponseDTO;
import com.blz.onlineclaimregistartion.dto.RegistrationDTO;
import com.blz.onlineclaimregistartion.dto.ResetPasswordDTO;
import com.blz.onlineclaimregistartion.dto.ResponseDTO;
import com.blz.onlineclaimregistartion.dto.UserDTO;
import com.blz.onlineclaimregistartion.model.User;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/onlineinsurancesystem/user")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {

	@Autowired
	private IUserService userService;

	@ApiOperation("For registration")
	@PostMapping("/register")
	public ResponseEntity<ResponseDTO> register(@Valid @RequestBody RegistrationDTO registrationDto,@RequestHeader String token) {
		User user = (userService.register(registrationDto,token));
		if(user!=null) {
			return new ResponseEntity<>(new ResponseDTO(200, "Your account has been successfully created", user),
					HttpStatus.OK);
	        }
		 return new ResponseEntity<>(new ResponseDTO(400,"Account creation failed"), HttpStatus.NOT_ACCEPTABLE);
	}

	@ApiOperation("For login")
	@PostMapping("/login")
	public ResponseEntity<LogInResponseDTO> login(@Valid @RequestBody UserDTO userDTO) {
		List<String> data = userService.login(userDTO);
		 if(data!=null) {
			 return new ResponseEntity<>(new LogInResponseDTO(200,"User login successful", data.get(0),data.get(1)), HttpStatus.OK);
	        }
		 return new ResponseEntity<>(new LogInResponseDTO(400,"User login failed"), HttpStatus.NOT_ACCEPTABLE);
	}

	@ApiOperation("For passwordForgot")
	@PostMapping("/forgot")
	public ResponseEntity<ResponseDTO> forgot(@Valid @RequestBody ForgotPasswordDTO fotgotPasswordDTO) {
		User user = userService.forgotPassword(fotgotPasswordDTO);
		return new ResponseEntity<>(new ResponseDTO(200, "Successfully send the mail", user), HttpStatus.OK);
	}

	@ApiOperation("For passwordReset")
	@PostMapping("/reset/{token}")
	public ResponseEntity<ResponseDTO> reset(@Valid @RequestBody ResetPasswordDTO resetPasswordDTO,
			@PathVariable("token") String token) {
		User user = userService.resetPassword(resetPasswordDTO, token);
		return new ResponseEntity<>(new ResponseDTO(200, "Successfully change the password", user), HttpStatus.OK);
	}
	
	@ApiOperation("For logout")
	@GetMapping("/logout")
	public ResponseEntity<ResponseDTO> logout() {
		return new ResponseEntity<>(new ResponseDTO(200,"User logout successful"), HttpStatus.OK);
	 }
}
	
	

