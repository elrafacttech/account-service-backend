package com.accountproject.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accountproject.api.entity.CostOfGoodsSold;

@Repository
public interface CostOfGoodsSoldRepo extends JpaRepository<CostOfGoodsSold, Integer> {

}
