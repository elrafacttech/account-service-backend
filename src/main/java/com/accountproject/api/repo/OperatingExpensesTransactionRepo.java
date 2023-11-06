package com.accountproject.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accountproject.api.entity.OperatingExpensesTransaction;

@Repository
public interface OperatingExpensesTransactionRepo extends JpaRepository<OperatingExpensesTransaction, Integer> {

}
