package com.accountproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accountproject.api.entity.Products;

public interface ProductsRepo extends JpaRepository<Products, Integer>{
	
	@Query("Select * from Products p where p.bu");

}
