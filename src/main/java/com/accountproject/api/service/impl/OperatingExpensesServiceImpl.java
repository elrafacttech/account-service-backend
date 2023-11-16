package com.accountproject.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountproject.api.dto.OperatingExpensesDto;
import com.accountproject.api.entity.OperatingExpenses;
import com.accountproject.api.repository.OperatingExpensesRepo;
import com.accountproject.api.service.OperatingExpensesService;

@Service
public class OperatingExpensesServiceImpl implements OperatingExpensesService {

	@Autowired
	OperatingExpensesRepo expensesRepo;

	@Autowired()
	private ModelMapper modelMapper;

	@Override
	public String addOperatingExapense(OperatingExpensesDto expensesDto) {
		OperatingExpenses expenses = modelMapper.map(expensesDto, OperatingExpenses.class);
//		expenses.setCode(expensesDto.getCode());
//		expenses.setCodeDescription(expensesDto.getCodeDescription());
		expensesRepo.save(expenses);
		return "Saved Succeessful";
	}

	@Override
	public List<OperatingExpensesDto> getAll() {
		List<OperatingExpenses> expenses = expensesRepo.findAll();
		List<OperatingExpensesDto> response = new ArrayList<>();
		for (OperatingExpenses set : expenses) {
			OperatingExpensesDto map = modelMapper.map(set, OperatingExpensesDto.class);
			response.add(map);
		}
		return response;
	}

}
