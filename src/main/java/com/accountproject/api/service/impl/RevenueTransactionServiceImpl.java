package com.accountproject.api.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountproject.api.dto.RevenueTransactionDto;
import com.accountproject.api.entity.RevenueTransaction;
import com.accountproject.api.repo.RevenueTransactionRepo;
import com.accountproject.api.service.RevenueTransactionService;

@Service
public class RevenueTransactionServiceImpl implements RevenueTransactionService {

	@Autowired
	RevenueTransactionRepo transactionRepo;
	
	@Override
	public String addRevenueTransaction(RevenueTransactionDto revenueTransactionDto) {
		RevenueTransaction transaction = new RevenueTransaction();
		transaction.setCode(revenueTransactionDto.getCode());
		transaction.setCodeDescription(revenueTransactionDto.getCodeDescription());
		transaction.setRevenue(revenueTransactionDto.getRevenue());
		transaction.setOrganizationCode(revenueTransactionDto.getOrganizationCode());
		transaction.setRevenueDate(LocalDateTime.now());
		transactionRepo.save(transaction);
		return "Saved Succeessful";
	}

}
