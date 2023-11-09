package com.accountproject.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accountproject.api.entity.IncomeStatement;

@Repository
public interface IncomeStatementRepo extends JpaRepository<IncomeStatement, Integer> {

}
