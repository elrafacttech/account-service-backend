package com.accountproject.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountproject.api.dto.OperatingExpensesDto;
import com.accountproject.api.entity.OperatingExpenses;
import com.accountproject.api.repo.OperatingExpensesRepo;
import com.accountproject.api.service.OperatingExpensesService;

@Service
public class OperatingExpensesServiceImpl implements OperatingExpensesService {

	
	@Autowired
	OperatingExpensesRepo expensesRepo;
	
	@Override
	public String addOperatingExapense(OperatingExpensesDto expensesDto) {
		OperatingExpenses expenses = new OperatingExpenses();
		expenses.setCode(expensesDto.getCode());
		expenses.setCodeDescription(expensesDto.getCodeDescription());
		return "Saved Succeessful";
	}

}
