package com.accountproject.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountproject.api.dto.RevenueTransactionDto;
import com.accountproject.api.service.RevenueTransactionService;

@RestController
@RequestMapping(value = "v1/api/user/revenueTransaction")
public class RevenueTransactionController {

	@Autowired
	RevenueTransactionService transactionService;

	@PostMapping("/add")
	public ResponseEntity<String> addRevenueTransaction(@RequestBody RevenueTransactionDto transactionDto) {
		String msg = transactionService.addRevenueTransaction(transactionDto);
		if (msg == null) {
			return ResponseEntity.ok("Error");
		}
		return ResponseEntity.ok(msg);
	}

}
