package com.accountproject.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountproject.api.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "v1/api/user")
public class UserController {

	@Autowired
	UserService userService;

}
