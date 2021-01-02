package com.blz.onlineclaimregistartion.service;

import javax.validation.Valid;
import com.blz.onlineclaimregistartion.dto.RegistrationDTO;
import com.blz.onlineclaimregistartion.dto.ResetPasswordDTO;
import com.blz.onlineclaimregistartion.dto.RestorePasswordDTO;
import com.blz.onlineclaimregistartion.dto.UserDTO;
import com.blz.onlineclaimregistartion.model.User;

public interface IUserService {

	String login(@Valid UserDTO userDTO);

	User register(@Valid RegistrationDTO registrationDTO);
	
	String restorePassword(@Valid RestorePasswordDTO recoverPasswordDTO);
	
	User resetPassword(@Valid ResetPasswordDTO resetPasswordDTO);

}
