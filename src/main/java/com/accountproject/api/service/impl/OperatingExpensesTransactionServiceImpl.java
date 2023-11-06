package com.accountproject.api.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountproject.api.dto.OperatingExpensesTransactionDto;
import com.accountproject.api.entity.OperatingExpensesTransaction;
import com.accountproject.api.repo.OperatingExpensesTransactionRepo;
import com.accountproject.api.service.OperatingExpensesTransactionService;

@Service
public class OperatingExpensesTransactionServiceImpl implements OperatingExpensesTransactionService {

	@Autowired
	OperatingExpensesTransactionRepo transactionRepo;

	@Override
	public String addOperatingExpensesTransaction(OperatingExpensesTransactionDto operatingExpensesTransactionDto) {
		OperatingExpensesTransaction transaction = new OperatingExpensesTransaction();
		transaction.setCode(operatingExpensesTransactionDto.getCode());
		transaction.setCodeDescription(operatingExpensesTransactionDto.getCodeDescription());
		transaction.setOperatingExpenses(operatingExpensesTransactionDto.getOperatingExpenses());
		transaction.setOrganizationCode(operatingExpensesTransactionDto.getOrganizationCode());
		transaction.setOperatingExpensesDate(LocalDateTime.now());
		transactionRepo.save(transaction);
		return "Saved Succeessful";
	}

}
