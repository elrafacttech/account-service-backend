package com.accountproject.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountproject.api.dto.PurchaseDto;
import com.accountproject.api.service.PurchaseService;

@RestController
@RequestMapping(value = "v1/api/business/purchase")
public class PurchaseController {
	
	@Autowired
	PurchaseService purchaseService;

	@GetMapping("/getAll")
	public ResponseEntity<List<PurchaseDto>> getAllSalesList() {
		List<PurchaseDto> response = purchaseService.findALLPurchase();
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/add")
	public ResponseEntity<PurchaseDto> addSalesDetails(@RequestBody PurchaseDto purchaseDto) {
		PurchaseDto response = purchaseService.addPurchaseDetails(purchaseDto);
		return ResponseEntity.ok(response);
	}

}
