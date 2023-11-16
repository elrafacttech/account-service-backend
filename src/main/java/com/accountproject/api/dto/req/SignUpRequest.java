package com.accountproject.api.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
	
	private Integer userId;

	private String username;

	private String email;

	private String password;

	private String confirmPassword;

	private String role;

	private String phoneNumber;

}
