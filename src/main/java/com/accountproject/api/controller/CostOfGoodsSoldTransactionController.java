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

import com.accountproject.api.dto.CostOfGoodsSoldTransactionDto;
import com.accountproject.api.service.CostOfGoodsSoldTransactionService;

@RestController
@RequestMapping(value = "v1/api/business/costOfGoodsSoldTransaction")
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

	@GetMapping("/getCogsByBusId/{businessId}")
	public ResponseEntity<List<CostOfGoodsSoldTransactionDto>> getRevenue(@PathVariable Integer businessId) {
		List<CostOfGoodsSoldTransactionDto> list = soldTransactionService.getByBusinessId(businessId);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/getCogsByProduct/{businessId}/{code}")
	public ResponseEntity<List<CostOfGoodsSoldTransactionDto>> getProductByBusinessId(@PathVariable Integer businessId,
			@PathVariable Integer code) {
		List<CostOfGoodsSoldTransactionDto> list = soldTransactionService.getProductByBusinessId(businessId, code);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/getCogsByDrCr/{businessId}/{code}/{drcr}")
	public ResponseEntity<List<CostOfGoodsSoldTransactionDto>> getDrCrByBusinessId(@PathVariable Integer businessId,
			@PathVariable Integer code, @PathVariable String drcr) {
		List<CostOfGoodsSoldTransactionDto> list = soldTransactionService.getDrCrByBusinessId(businessId, code, drcr);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/getCogsByFromDate/{businessId}/{code}/{drcr}/{fromDate}")
	public ResponseEntity<List<CostOfGoodsSoldTransactionDto>> getFromDateByBusinessId(@PathVariable Integer businessId,
			@PathVariable Integer code, @PathVariable String drcr, @PathVariable String fromDate) {
		List<CostOfGoodsSoldTransactionDto> list = soldTransactionService.getFromDateByBusinessId(businessId, code,
				drcr, fromDate);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/getCogsByToDate/{businessId}/{code}/{drcr}/{fromDate}/{toDate}")
	public ResponseEntity<List<CostOfGoodsSoldTransactionDto>> getToDateByBusinessId(@PathVariable Integer businessId,
			@PathVariable Integer code, @PathVariable String drcr, @PathVariable String fromDate,
			@PathVariable String toDate) {
		List<CostOfGoodsSoldTransactionDto> list = soldTransactionService.getToDateByBusinessId(businessId, code, drcr,
				fromDate, toDate);
		return ResponseEntity.ok(list);
	}

}
