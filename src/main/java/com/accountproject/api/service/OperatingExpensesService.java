package com.accountproject.api.service;

import java.util.List;

import com.accountproject.api.dto.OperatingExpensesDto;

public interface OperatingExpensesService {
	
	String addOperatingExapense(OperatingExpensesDto expensesDto);
	List<OperatingExpensesDto> getAll();

}
