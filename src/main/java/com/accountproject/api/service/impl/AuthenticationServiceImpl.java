package com.accountproject.api.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.accountproject.api.Constants.CommonConstants;
import com.accountproject.api.config.CustomPasswordEncoder;
import com.accountproject.api.dto.req.SignUpRequest;
import com.accountproject.api.dto.req.SigninRequest;
import com.accountproject.api.dto.res.JwtAuthenticationResponse;
import com.accountproject.api.entity.Users;
import com.accountproject.api.repository.UserRepo;
import com.accountproject.api.service.AuthenticationService;
import com.accountproject.api.service.JwtService;

import lombok.RequiredArgsConstructor;

/**
 * Service Class for managing {@link AuthenticationServiceImpl}.request
 * 
 * @author Raghu
 */

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepo userRepository;
   // private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    
    @Autowired
    private final CustomPasswordEncoder passwordEncoder;

   

    @Override
    public JwtAuthenticationResponse adminSignin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException(CommonConstants.INVALIDEMAILORPASSWORD));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).role(user.getRole()).userId(user.getUserId()).build();
    }

	@Override
	public String adminSignup(SignUpRequest request) {
		 var user = Users.builder()
				 .username(request.getUsername())
				 .email(request.getEmail())
				 .confirmPassword(passwordEncoder.encode(request.getConfirmPassword()))
				 .password(passwordEncoder.encode(request.getPassword()))
				 .phoneNumber(request.getPhoneNumber())
				 .role(request.getRole()).build();
	        userRepository.save(user);
	        return CommonConstants.ADMINUSERCREATEDSUCCESSFULLY;
	}
}