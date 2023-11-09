package com.accountproject.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountproject.api.dto.res.IncomeStatementRes;
import com.accountproject.api.service.IncomeStatementService;

@RestController
@RequestMapping(value = "v1/api/business/incomeStmt")
public class IncomeStatementController {
	
	@Autowired
	IncomeStatementService statementService;
	
	@PostMapping("/add")
	public ResponseEntity<IncomeStatementRes> addIncomeStmt() {
		IncomeStatementRes response = statementService.addIncomeStmt();
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/getByBusinessId")
	public ResponseEntity<IncomeStatementRes> getIncomeStmt(@PathVariable Integer businessId) {
		IncomeStatementRes response = statementService.addIncomeStmt();
		return ResponseEntity.ok(response);
	}

}
