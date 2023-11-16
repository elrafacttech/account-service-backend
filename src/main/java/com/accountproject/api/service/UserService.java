package com.accountproject.api.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.accountproject.api.dto.req.SignUpRequest;

public interface UserService {
	
	/** Create a new user in UserInfo */
	String createUser(SignUpRequest request);
	
	UserDetailsService userDetailsService();


}
