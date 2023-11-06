package com.accountproject.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountproject.api.dto.CostOfGoodsSoldTransactionDto;
import com.accountproject.api.service.CostOfGoodsSoldTransactionService;

@RestController
@RequestMapping(value = "v1/api/user/costOfGoodsSoldTransaction")
public class CostOfGoodsSoldTransactionController {

	@Autowired
	CostOfGoodsSoldTransactionService soldTransactionService;

	@PostMapping("/add")
	public ResponseEntity<String> addCostOfGoodsSoldTransaction(
			@RequestBody CostOfGoodsSoldTransactionDto soldTransactionDto) {
		String msg = soldTransactionService.addCostOfGoodsSoldTransaction(soldTransactionDto);
		if (msg == null) {
			return ResponseEntity.ok("Error");
		}
		return ResponseEntity.ok(msg);
	}

}
