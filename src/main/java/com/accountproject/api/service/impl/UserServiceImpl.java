package com.accountproject.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.accountproject.api.config.CustomPasswordEncoder;
import com.accountproject.api.dto.req.SignUpRequest;
import com.accountproject.api.entity.Users;
import com.accountproject.api.repository.UserRepo;
import com.accountproject.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepository;
	
	@Autowired
	private CustomPasswordEncoder passwordEncoder;

	@Override
	public String createUser(SignUpRequest request) {

		if (userRepository.existsByUsername(request.getUsername())) {
			return  "User Name already exist by this name";
		}
		if (userRepository.existsByEmail(request.getEmail())) {
			return "Mail Id already exist by this email";
		}

		var user = Users.builder().username(request.getUsername()).email(request.getEmail())
				// .confirmPassword(passwordEncoder.encode(request.getConfirmPassword()))
				.password(passwordEncoder.encode(request.getPassword()))
				// .otherPassword(passwordEncoder.encode(request.getOtherPassword()))
				.confirmPassword(passwordEncoder.encode(request.getConfirmPassword()))
				.phoneNumber(request.getPhoneNumber()).build();
		userRepository.save(user);
		return "User created successfully";
	}

	@Override
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) {
				return userRepository.findByUsername(username)
						.orElseThrow(() -> new UsernameNotFoundException("User not found"));
			}
		};
	}



}
