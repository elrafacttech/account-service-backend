package com.accountproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accountproject.api.entity.BusinessDetails;

@Repository
public interface BusinessDetailsRepo extends JpaRepository<BusinessDetails, Integer> {
	
	@Query(value="Select * from business_details where business_id = : businessId",nativeQuery=true)
	BusinessDetails  getByBusinessId(@Param("businessId") int businesId );
	

}
