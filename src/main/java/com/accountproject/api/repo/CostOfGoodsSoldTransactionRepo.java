package com.accountproject.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accountproject.api.entity.CostOfGoodsSoldTransaction;

@Repository
public interface CostOfGoodsSoldTransactionRepo extends JpaRepository<CostOfGoodsSoldTransaction, Integer> {

}
