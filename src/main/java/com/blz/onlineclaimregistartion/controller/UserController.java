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

@RestController
@RequestMapping("/onlineinsurancesystem")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {
	
	@Autowired
	private IUserService userService;

    @ApiOperation("For registration")
    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody @Valid RegistrationDTO registrationDto)  {
          if (userService.register(registrationDto))
            return new ResponseEntity<>(new ResponseDTO(200,"user register successful"), HttpStatus.OK);
        return new ResponseEntity<>(new ResponseDTO(400, "user register unsuccessful"), HttpStatus.BAD_REQUEST);
    }
	
	@PostMapping("/login")
	@ApiOperation("For Log")
	public ResponseEntity<ResponseDTO> login(@RequestBody @Valid UserDTO userDTO){
		 String token = userService.login(userDTO);
	        if(token!=null) {
	            return new ResponseEntity<>(new ResponseDTO(200, "User login successful", token), HttpStatus.OK);
	        }
	   return new ResponseEntity<>(new ResponseDTO(400, "User login unsuccessful"), HttpStatus.NOT_ACCEPTABLE);
	}   
}
