package com.blz.onlineclaimregistartion.service;

import javax.validation.Valid;

import com.blz.onlineclaimregistartion.dto.RegistrationDTO;
import com.blz.onlineclaimregistartion.dto.UserDTO;
import com.blz.onlineclaimregistartion.model.User;

public interface IUserService {

	String login(@Valid UserDTO userDTO);

	User register(@Valid RegistrationDTO registrationDto);

}
