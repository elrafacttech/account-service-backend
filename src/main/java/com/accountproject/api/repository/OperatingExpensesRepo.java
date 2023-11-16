package com.accountproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accountproject.api.entity.OperatingExpenses;

@Repository
public interface OperatingExpensesRepo extends JpaRepository<OperatingExpenses, Integer> {

}
