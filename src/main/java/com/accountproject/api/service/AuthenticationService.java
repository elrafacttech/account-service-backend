package com.accountproject.api.service;

import com.accountproject.api.dto.req.SignUpRequest;
import com.accountproject.api.dto.req.SigninRequest;
import com.accountproject.api.dto.res.JwtAuthenticationResponse;

/**
 * Service interface for managing {@link AuthenticationService}.request
 * 
 * @author Raghu
 */

public interface AuthenticationService {

	/** Perform authentication for admin users. */
	JwtAuthenticationResponse adminSignin(SigninRequest request);

	/** Perform signup for admin users. */
	String adminSignup(SignUpRequest request);
}