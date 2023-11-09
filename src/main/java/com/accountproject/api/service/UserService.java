package com.accountproject.api.service;

import com.accountproject.api.dto.req.AuthRequestDto;
import com.accountproject.api.dto.req.UserRequestDto;
import com.accountproject.api.dto.res.LoginResDto;
import com.accountproject.api.dto.res.UserResponseDto;

public interface UserService {

	UserResponseDto createUser(UserRequestDto signUp);

	UserResponseDto getByUserName(String userName);

	LoginResDto loginUser(AuthRequestDto loginDetails);

}
