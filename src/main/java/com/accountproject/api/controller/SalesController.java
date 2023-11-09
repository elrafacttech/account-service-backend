package com.accountproject.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountproject.api.dto.SalesDto;
import com.accountproject.api.dto.res.SalesResDto;
import com.accountproject.api.service.SalesService;

@RestController
@RequestMapping(value = "v1/api/business/sales")
public class SalesController {

	@Autowired
	SalesService salesService;

	@GetMapping("/getAll")
	public ResponseEntity<List<SalesResDto>> getAllSalesList() {
		List<SalesResDto> response = salesService.getAllSalesList();
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/add")
	public ResponseEntity<SalesDto> addSalesDetails(@RequestBody SalesDto salesDto) {
		SalesDto response = salesService.addSalesDetails(salesDto);
		return ResponseEntity.ok(response);
	}

}
