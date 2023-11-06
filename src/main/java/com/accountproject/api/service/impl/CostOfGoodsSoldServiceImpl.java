package com.accountproject.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountproject.api.dto.CostOfGoodsSoldDto;
import com.accountproject.api.entity.CostOfGoodsSold;
import com.accountproject.api.repo.CostOfGoodsSoldRepo;
import com.accountproject.api.service.CostOfGoodsSoldService;

@Service
public class CostOfGoodsSoldServiceImpl implements CostOfGoodsSoldService {

	@Autowired
	CostOfGoodsSoldRepo costOfGoodsSoldRepo;
	
	@Override
	public String addCostOfGoodsSold(CostOfGoodsSoldDto costOfGoodsSoldDto) {
		CostOfGoodsSold costOfGoodsSold = new CostOfGoodsSold();
		costOfGoodsSold.setCode(costOfGoodsSoldDto.getCode());
		costOfGoodsSold.setCode(costOfGoodsSoldDto.getCode());
		return "Saved Succeessful";
	}

}
