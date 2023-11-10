package com.accountproject.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountproject.api.dto.req.UserRequestDto;
import com.accountproject.api.dto.res.UserResponseDto;
import com.accountproject.api.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "v1/api/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/createuser")
	public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
		UserResponseDto users = userService.createUser(userRequestDto);
		return ResponseEntity.ok(users);
	}

}
