package com.accountproject.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountproject.api.dto.RevenueDto;
import com.accountproject.api.service.RevenueService;

@RestController
@RequestMapping(value = "v1/api/user/revenue")
public class RevenueController {

	@Autowired
	RevenueService revenueService;

	@PostMapping("/add")
	public ResponseEntity<String> addRevenueDeatils(@RequestBody RevenueDto revenueDto) {
		String msg = revenueService.addRevenueDetails(revenueDto);
		if (msg == null) {
			return ResponseEntity.ok("Error");
		}
		return ResponseEntity.ok(msg);
	}
}
