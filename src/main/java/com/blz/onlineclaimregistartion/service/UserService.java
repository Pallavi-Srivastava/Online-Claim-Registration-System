package com.blz.onlineclaimregistartion.service;

import java.util.Base64;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
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
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

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
		return user.getPassword();
	}
	
	
	

    

	@Override
	public User resetPassword(@Valid ResetPasswordDTO resetPasswordDTO) {
		
        final String username = "devangmranganath@gmail.com";
        final String password = "@Reset2020";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("14691ao3c5@gmail.com, pallavisrivastava858@gmail.com")
            );
            message.setSubject("Testing Gmail SSL");
            message.setText("Dear Pallavi Srivastava,"
                    + "\n\n Please do not spam my email this is just checking the gmail !");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }		
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
//			EmailUtility.sendEmail();
			return userRepository.save(user);
		}
		//throw new UserException("Password Mismatch");
		else {
			throw new UserException("Password Mismatch");
		}
	}

}
