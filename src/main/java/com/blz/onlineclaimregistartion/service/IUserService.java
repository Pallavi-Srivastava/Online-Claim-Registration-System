package com.blz.onlineclaimregistartion.service;

import javax.validation.Valid;

import com.blz.onlineclaimregistartion.dto.RegistrationDTO;
import com.blz.onlineclaimregistartion.dto.UserDTO;

public interface IUserService {

	String login(@Valid UserDTO userDTO);

	boolean register(@Valid RegistrationDTO registrationDto);

}
