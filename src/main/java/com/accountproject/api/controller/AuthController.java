package com.accountproject.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountproject.api.dto.req.SignUpRequest;
import com.accountproject.api.dto.req.SigninRequest;
import com.accountproject.api.dto.res.JwtAuthenticationResponse;
import com.accountproject.api.service.AuthenticationService;
import com.accountproject.api.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1/api/user/authenticate")
@RequiredArgsConstructor
public class AuthController {

	@Autowired
	UserService userService;
	
	 private final AuthenticationService authenticationService;
	    
	    /**Create a Newuser in userinfo.*/
	    @PostMapping("/signup")
	    @CrossOrigin(origins = "*", allowedHeaders = "*")
	    public ResponseEntity<String> signup(@RequestBody SignUpRequest request) {
	        return ResponseEntity.ok(authenticationService.adminSignup(request));
	    }
	    
	    /** Login a User.*/
	    @PostMapping("/signin")
	    @CrossOrigin(origins = "*", allowedHeaders = "*")
	    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
	        return ResponseEntity.ok(authenticationService.adminSignin(request));
	    }

	
}
