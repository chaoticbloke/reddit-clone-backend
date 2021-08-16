 package com.example.redditclone.services;

import java.time.Instant;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.redditclone.Repos.UserRepository;
import com.example.redditclone.Repos.VerificationTokenRepository;
import com.example.redditclone.dto.RegisterRequest;
import com.example.redditclone.models.NotificationEmail;
import com.example.redditclone.models.User;
import com.example.redditclone.models.VerificationToken;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	
//	@Autowired
//	private UserRepository userRepository;
//	atowired uses field injector. Spring suggest to use constructor injection. we do by final and @AllArgs
	
	private final PasswordEncoder passwordEncoder;
	
	private final UserRepository userRepository;
	
	private final VerificationTokenRepository verificationTokenRepository;
	
	private final MailService mailService;
	
	
	@Transactional
	public void signup(RegisterRequest registerRequest) {
		
		User user = new User();
		
		user.setUsername(registerRequest.getUsername());
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		user.setEmail(registerRequest.getEmail());
		user.setCreated(Instant.now());
		user.setEnabled(false);
		userRepository.save(user);
		String token = gererateVerificationToken(user);
		
		  mailService.sendEmail(new NotificationEmail("Please Activate your Account",
	                user.getEmail(), "Thank you for signing up to Spring Reddit, " +
	                "please click on the below url to activate your account : " +
	                "http://localhost:8080/api/auth/accountVerification/" + token));
	}


	private String gererateVerificationToken(User user) {
		// TODO Auto-generated method stub
		String token = UUID.randomUUID().toString();
		
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setToken(token);
		verificationToken.setUser(user);
		
		verificationTokenRepository.save(verificationToken);
		
		return token;
	
	}

	 
}
