package com.accountproject.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountproject.api.dto.OperatingExpensesDto;
import com.accountproject.api.service.OperatingExpensesService;

@RestController
@RequestMapping(value = "v1/api/user/operatingExpenses")
public class OperatingExpensesController {

	@Autowired
	OperatingExpensesService expensesService;

	@PostMapping("/add")
	public ResponseEntity<String> addOperatingExpensesDeatils(@RequestBody OperatingExpensesDto expensesDto) {
		String msg = expensesService.addOperatingExapense(expensesDto);
		if (msg == null) {
			return ResponseEntity.ok("Error");
		}
		return ResponseEntity.ok(msg);
	}

}
