package com.accountproject.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountproject.api.dto.OperatingExpensesTransactionDto;
import com.accountproject.api.service.OperatingExpensesTransactionService;

@RestController
@RequestMapping(value = "v1/api/user/operatingExpensesTransaction")
public class OperatingExpensesTransactionController {

	@Autowired
	OperatingExpensesTransactionService transactionService;

	@PostMapping("/add")
	public ResponseEntity<String> addOperatingExpensesTransaction(
			@RequestBody OperatingExpensesTransactionDto transactionDto) {
		String msg = transactionService.addOperatingExpensesTransaction(transactionDto);
		if (msg == null) {
			return ResponseEntity.ok("Error");
		}
		return ResponseEntity.ok(msg);
	}
}
