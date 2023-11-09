package com.accountproject.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountproject.api.dto.req.AuthRequestDto;
import com.accountproject.api.dto.res.LoginResDto;
import com.accountproject.api.service.UserService;

@RestController
@RequestMapping("/v1/api/user/authenticate")
public class AuthController {

	@Autowired
	UserService userService;

	@PostMapping("/login")
	public ResponseEntity<LoginResDto> userLogin(@RequestBody AuthRequestDto authRequestDto) {
		LoginResDto resDto = userService.loginUser(authRequestDto);
		return ResponseEntity.ok(resDto);
	}
}
