package com.accountproject.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountproject.api.dto.req.AuthRequestDto;
import com.accountproject.api.dto.req.UserRequestDto;
import com.accountproject.api.dto.res.LoginResDto;
import com.accountproject.api.dto.res.UserResponseDto;
import com.accountproject.api.entity.Users;
import com.accountproject.api.repo.UserRepo;
import com.accountproject.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Override
	public UserResponseDto createUser(UserRequestDto requestDto) {
		Users user = new Users();
		user.setUserName(requestDto.getUserName());
		user.setPassword(requestDto.getPassword());
		userRepo.save(user);
		// UserResponseDto responseDto = modelMapper.map(user,UserResponseDto.class);
		UserResponseDto responseDto = new UserResponseDto();
		responseDto.setUserName(user.getUserName());
		responseDto.setPassword(user.getPassword());
		return responseDto;
	}

	@Override
	public UserResponseDto getByUserName(String userName) {
		Users users = userRepo.findByUserName(userName);

		return null;
	}

	@Override
	public LoginResDto loginUser(AuthRequestDto loginDetails) {
		LoginResDto response = new LoginResDto();
		Users user = userRepo.findByUserName(loginDetails.getUsername());
		if (loginDetails.getPassword().matches(user.getPassword())) {
			response.setUserId(user.getUserId());
			response.setUsername(user.getUserName());
			return response;
		}else {
			return response;
		}
		
	}

}
