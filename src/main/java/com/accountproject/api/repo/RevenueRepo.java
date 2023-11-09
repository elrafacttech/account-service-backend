package com.accountproject.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accountproject.api.entity.Revenue;

@Repository
public interface RevenueRepo extends JpaRepository<Revenue, Integer> {
	

}
