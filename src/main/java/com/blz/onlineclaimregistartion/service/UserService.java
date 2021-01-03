package com.blz.onlineclaimregistartion.service;

import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.blz.onlineclaimregistartion.dto.RegistrationDTO;
import com.blz.onlineclaimregistartion.dto.ResetPasswordDTO;
import com.blz.onlineclaimregistartion.dto.RestorePasswordDTO;
import com.blz.onlineclaimregistartion.dto.UserDTO;
import com.blz.onlineclaimregistartion.exceptions.UserException;
import com.blz.onlineclaimregistartion.model.User;
import com.blz.onlineclaimregistartion.repository.UserRepository;
import com.blz.onlineclaimregistartion.utility.JsonWebToken;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User register(@Valid RegistrationDTO registrationDTO) {
		User findByName = userRepository.findByName(registrationDTO.getUserName());
		if (findByName != null) {
			throw new UserException("User Already Exist");
		}
		User userDetails = new User();
		BeanUtils.copyProperties(registrationDTO, userDetails);
		userDetails.setPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		return userRepository.save(userDetails);
	}

	@Override
	public String login(@Valid UserDTO userDTO) {

		User findByName = userRepository.findByName(userDTO.getUserName());
		if (findByName == null) {
			throw new UserException("User not Exist");
		}
		if (bCryptPasswordEncoder.matches(userDTO.getPassword(), findByName.getPassword())) {
			System.out.println("user Id " + findByName.getUserId());
			String token = JsonWebToken.createToken(findByName.getUserId());
			Long decodeJWT = JsonWebToken.decodeToken(token);
			userRepository.save(findByName);
			return token;
		}
		return null;
	}

	@Override
	public String restorePassword(@Valid RestorePasswordDTO restorePasswordDTO) {

		User user = userRepository.findByEmail(restorePasswordDTO.getEmail());
		if (user == null) {
			throw new UserException("Email account that you tried to reach does not exist");
		}
		return bCryptPasswordEncoder.encode(user.getPassword());
	}

	@Override
	public User resetPassword(@Valid ResetPasswordDTO resetPasswordDTO) {
		User user = userRepository.findByEmail(resetPasswordDTO.getEmail());
		System.out.println(user);
		if (user == null) {
			throw new UserException("Email account that you tried to reach does not exist");
		}

		System.out.println(resetPasswordDTO.toString());
		if (resetPasswordDTO.newPassword.equals(resetPasswordDTO.confirmPassword)) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(resetPasswordDTO.newPassword);
			user.setPassword(encodedPassword);
			return userRepository.save(user);
		}
		//throw new UserException("Password Mismatch");
		else {
			throw new UserException("Password Mismatch");
		}
	}

}
