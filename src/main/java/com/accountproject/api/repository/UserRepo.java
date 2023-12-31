package com.accountproject.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accountproject.api.entity.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{
	
	Optional<Users> findByUsername(String username);
	
	Boolean existsByUsername(String username);
	
	Boolean existsByEmail(String email);

}
