package com.accountproject.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.accountproject.api")
public class AccountprojectServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountprojectServiceApplication.class, args);
	}

}
