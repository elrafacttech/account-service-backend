package com.accountproject.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.accountproject.api.entity.RevenueTransaction;

@Repository
public interface RevenueTransactionRepo extends JpaRepository<RevenueTransaction, Integer> {
	
	@Query(value = " SELECT SUM(revenue) as revenue", nativeQuery = true)
	Object[] findAdministrationById();

}
