package com.accountproject.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accountproject.api.dto.OperatingExpensesTransactionDto;
import com.accountproject.api.service.OperatingExpensesTransactionService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "v1/api/business/operatingExpensesTransaction")
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

	@GetMapping("/getOperatExpByBusId/{businessId}")
	public ResponseEntity<List<OperatingExpensesTransactionDto>> getRevenue(@PathVariable Integer businessId) {
		List<OperatingExpensesTransactionDto> list = transactionService.getByBusinessId(businessId);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/getOperatExpByProduct/{businessId}/{code}")
	public ResponseEntity<List<OperatingExpensesTransactionDto>> getProductByBusinessId(
			@PathVariable Integer businessId, @PathVariable Integer code) {
		List<OperatingExpensesTransactionDto> list = transactionService.getProductByBusinessId(businessId, code);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/getOperatExpByDrCr/{businessId}/{code}/{drcr}")
	public ResponseEntity<List<OperatingExpensesTransactionDto>> getDrCrByBusinessId(@PathVariable Integer businessId,
			@PathVariable Integer code, @PathVariable String drcr) {
		List<OperatingExpensesTransactionDto> list = transactionService.getDrCrByBusinessId(businessId, code, drcr);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/getOperatExpByFromDate/{businessId}/{code}/{drcr}/{fromDate}")
	public ResponseEntity<List<OperatingExpensesTransactionDto>> getFromDateByBusinessId(
			@PathVariable Integer businessId, @PathVariable Integer code, @PathVariable String drcr,
			@PathVariable String fromDate) {
		List<OperatingExpensesTransactionDto> list = transactionService.getFromDateByBusinessId(businessId, code, drcr,
				fromDate);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/getOperatExpByToDate/{businessId}/{code}/{drcr}/{fromDate}/{toDate}")
	public ResponseEntity<List<OperatingExpensesTransactionDto>> getToDateByBusinessId(@PathVariable Integer businessId,
			@PathVariable Integer code, @PathVariable String drcr, @PathVariable String fromDate,
			@PathVariable String toDate) {
		List<OperatingExpensesTransactionDto> list = transactionService.getToDateByBusinessId(businessId, code, drcr,
				fromDate, toDate);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/filter")
	public ResponseEntity<List<OperatingExpensesTransactionDto>> filterOperExpTrans(
			@RequestParam(required = false) String businessId, @RequestParam(required = false) String code,
			@RequestParam(required = false) String drcr, @RequestParam(required = false) String fromDate,
			@RequestParam(required = false) String toDate) {
		List<OperatingExpensesTransactionDto> list = transactionService.filter(businessId, code, drcr,
				fromDate, toDate);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/getProduct")
	public ResponseEntity<List<OperatingExpensesTransactionDto>> getProduct() {
		List<OperatingExpensesTransactionDto> list = transactionService.getProdcut();

		return ResponseEntity.ok(list);
	}
}
