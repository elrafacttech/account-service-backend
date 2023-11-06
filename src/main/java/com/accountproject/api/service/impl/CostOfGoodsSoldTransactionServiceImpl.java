package com.accountproject.api.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountproject.api.dto.CostOfGoodsSoldTransactionDto;
import com.accountproject.api.entity.CostOfGoodsSoldTransaction;
import com.accountproject.api.repo.CostOfGoodsSoldTransactionRepo;
import com.accountproject.api.service.CostOfGoodsSoldTransactionService;

@Service
public class CostOfGoodsSoldTransactionServiceImpl implements CostOfGoodsSoldTransactionService {

	@Autowired
	CostOfGoodsSoldTransactionRepo soldTransactionRepo;
	
	@Override
	public String addCostOfGoodsSoldTransaction(CostOfGoodsSoldTransactionDto soldTransactionDto) {
		CostOfGoodsSoldTransaction transaction = new CostOfGoodsSoldTransaction();
		transaction.setCode(soldTransactionDto.getCode());
		transaction.setCodeDescription(soldTransactionDto.getCodeDescription());
		transaction.setCostOfGoodsSold(soldTransactionDto.getCostOfGoodsSold());
		transaction.setOrganizationCode(soldTransactionDto.getOrganizationCode());
		transaction.setCostOfGoodsSoldDate(LocalDateTime.now());
		soldTransactionRepo.save(transaction);
		return "Saved Succeessful";
	}

}
