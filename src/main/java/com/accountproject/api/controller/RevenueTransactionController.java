package com.accountproject.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountproject.api.dto.RevenueTransactionDto;
import com.accountproject.api.dto.res.RevenueSumDto;
import com.accountproject.api.service.RevenueTransactionService;

@RestController
@RequestMapping(value = "v1/api/business/revenueTransaction")
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

	@GetMapping("/getRevenue")
	public ResponseEntity<List<RevenueSumDto>> getRevenue() {
		List<RevenueSumDto> list = transactionService.getRevenue();

		return ResponseEntity.ok(list);
	}

	@GetMapping("/getRevenueByBusId/{businessId}")
	public ResponseEntity<List<RevenueTransactionDto>> getRevenue(@PathVariable Integer businessId) {
		List<RevenueTransactionDto> list = transactionService.getByBusinessId(businessId);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/getRevenueByProduct/{businessId}/{code}")
	public ResponseEntity<List<RevenueTransactionDto>> getProductByBusinessId(@PathVariable Integer businessId,
			@PathVariable Integer code) {
		List<RevenueTransactionDto> list = transactionService.getProductByBusinessId(businessId, code);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/getRevenueByDrCr/{businessId}/{code}/{drcr}")
	public ResponseEntity<List<RevenueTransactionDto>> getDrCrByBusinessId(@PathVariable Integer businessId,
			@PathVariable Integer code, @PathVariable String drcr) {
		List<RevenueTransactionDto> list = transactionService.getDrCrByBusinessId(businessId, code, drcr);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/getRevenueByFromDate/{businessId}/{code}/{drcr}/{fromDate}")
	public ResponseEntity<List<RevenueTransactionDto>> getFromDateByBusinessId(@PathVariable Integer businessId,
			@PathVariable Integer code, @PathVariable String drcr, @PathVariable String fromDate) {
		List<RevenueTransactionDto> list = transactionService.getFromDateByBusinessId(businessId, code, drcr, fromDate);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/getRevenueByToDate/{businessId}/{code}/{drcr}/{fromDate}/{toDate}")
	public ResponseEntity<List<RevenueTransactionDto>> getToDateByBusinessId(@PathVariable Integer businessId,
			@PathVariable Integer code, @PathVariable String drcr, @PathVariable String fromDate,
			@PathVariable String toDate) {
		List<RevenueTransactionDto> list = transactionService.getToDateByBusinessId(businessId, code, drcr, fromDate,
				toDate);
		return ResponseEntity.ok(list);
	}

}
