package com.accountproject.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.accountproject.api.entity.Sales;

@Repository
public interface SalesRepo extends JpaRepository<Sales, Integer> {
	
	@Query(value ="SELECT * FROM sales",nativeQuery = true)
	List<Sales>  getAllSalesList();

}
