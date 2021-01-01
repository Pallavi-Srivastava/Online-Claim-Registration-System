package com.blz.onlineclaimregistartion.service;

import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.blz.onlineclaimregistartion.dto.RegistrationDTO;
import com.blz.onlineclaimregistartion.dto.UserDTO;
import com.blz.onlineclaimregistartion.exceptions.UserException;
import com.blz.onlineclaimregistartion.model.User;
import com.blz.onlineclaimregistartion.repository.UserRepository;
import com.blz.onlineclaimregistartion.utility.JsonWebToken;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository insuranceClaimRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User register(@Valid RegistrationDTO registrationDto) {
		User findByName = insuranceClaimRepository.findByName(registrationDto.getUserName());
		if (findByName != null) {
			throw new UserException("User Already Exist");
		}
		User userDetails = new User();
		BeanUtils.copyProperties(registrationDto, userDetails);
		userDetails.setPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		return insuranceClaimRepository.save(userDetails);
	}

	@Override
	public String login(@Valid UserDTO userDTO) {

		User findByName = insuranceClaimRepository.findByName(userDTO.getUserName());
		if (findByName == null) {
			throw new UserException("User not Exist");
		}
		if (bCryptPasswordEncoder.matches(userDTO.getPassword(), findByName.getPassword())) {
			System.out.println("user Id " + findByName.getUserId());
			String token = JsonWebToken.createToken(findByName.getUserId());
			Long decodeJWT = JsonWebToken.decodeToken(token);
			insuranceClaimRepository.save(findByName);
			return token;
		}
		return null;
	}

}
