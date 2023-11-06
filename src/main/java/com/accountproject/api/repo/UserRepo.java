package com.accountproject.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accountproject.api.entity.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{
	
	Users findByUserName(String userName);

	
}
