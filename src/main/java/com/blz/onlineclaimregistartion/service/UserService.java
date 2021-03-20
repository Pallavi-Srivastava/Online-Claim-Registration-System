package com.blz.onlineclaimregistartion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.blz.onlineclaimregistartion.dto.ForgotPasswordDTO;
import com.blz.onlineclaimregistartion.dto.RegistrationDTO;
import com.blz.onlineclaimregistartion.dto.ResetPasswordDTO;
import com.blz.onlineclaimregistartion.dto.UserDTO;
import com.blz.onlineclaimregistartion.enums.UserRoleEnum;
import com.blz.onlineclaimregistartion.exceptions.UserException;
import com.blz.onlineclaimregistartion.model.User;
import com.blz.onlineclaimregistartion.repository.UserRepository;
import com.blz.onlineclaimregistartion.utility.JsonWebToken;

@Service
public class UserService implements IUserService {

	ForgotPasswordDTO forgotPasswordDTO;
	User user;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User register(@Valid RegistrationDTO registrationDTO, String token) {
		long userId = JsonWebToken.decodeToken(token);
		System.out.println(userId);
		user = userRepository.findById(userId);
		if (user.roleCode.equals(UserRoleEnum.USER.getUserRole())) {
			throw new UserException("Admin/Agent can only create the account");
		}
		User userDetails = new User(registrationDTO, userId);
		userDetails.setPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		return userRepository.save(userDetails);
	}

	@Override
	public List<String> login(@Valid UserDTO userDTO) {

		int count = 0;

		user = userRepository.findByName(userDTO.getUserName());
		
		List<String> response=new ArrayList();
		String userRole=user.getRoleCode();
		System.out.println("user "+user+"userRole "+userRole);
		if (user == null) {
			count++;
			if (count >= 3) {
				user.setInactiveUser(true);
			}
			throw new UserException("User not Exist");
		}

		if (bCryptPasswordEncoder.matches(userDTO.getPassword(), user.getPassword())) {
			user.setInactiveUser(false);
			String token = JsonWebToken.createToken(user.getUserId());
			userRepository.save(user);
			response.add(token);
			response.add(userRole);
			return response;
		}
		return null;
	}
	

	@Override
	public User forgotPassword(@Valid ForgotPasswordDTO forgotPasswordDTO) {

		user = userRepository.findByEmail(forgotPasswordDTO.getEmail());
		if (user == null) {
			throw new UserException("Email account that you tried to reach does not exist");
		}
		String token = JsonWebToken.createToken(user.getUserId());
		String url = "http://localhost:4200/reset-password/";

		final String username = "insuranceclaimsystem@gmail.com";
		final String password = "@Reset2020";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(forgotPasswordDTO.getEmail()));
			message.setSubject("Testing Gmail SSL");
			message.setText("Dear " + user.getUserName() + ","
					+ "\n\n To Complete the password reset process,please click here: " + url + token);

			Transport.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User resetPassword(@Valid ResetPasswordDTO resetPasswordDTO, String token) {
		if (resetPasswordDTO.newPassword.equals(resetPasswordDTO.confirmPassword)) {
			long id = JsonWebToken.decodeToken(token);
			user = userRepository.findById(id);
			if (user != null) {
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String encodedPassword = passwordEncoder.encode(resetPasswordDTO.newPassword);
				user.setPassword(encodedPassword);
				return userRepository.save(user);
			}
			throw new UserException("User  not Present");
		}
		throw new UserException("Password mismatch");
	}
}