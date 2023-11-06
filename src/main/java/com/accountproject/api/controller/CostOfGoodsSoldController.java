package com.accountproject.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountproject.api.dto.CostOfGoodsSoldDto;
import com.accountproject.api.service.CostOfGoodsSoldService;

@RestController
@RequestMapping(value = "v1/api/user/costOfGoodsSold")
public class CostOfGoodsSoldController {
	
	@Autowired
	CostOfGoodsSoldService costOfGoodsSoldService;

	@PostMapping("/add")
	public ResponseEntity<String> addCostOfGoodsSoldDeatils(@RequestBody CostOfGoodsSoldDto costOfGoodsSoldDto) {
		String msg = costOfGoodsSoldService.addCostOfGoodsSold(costOfGoodsSoldDto);
		if (msg == null) {
			return ResponseEntity.ok("Error");
		}
		return ResponseEntity.ok(msg);
	}

}
