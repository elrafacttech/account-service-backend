package com.accountproject.api.service;

import java.util.List;

import com.accountproject.api.dto.CostOfGoodsSoldDto;

public interface CostOfGoodsSoldService {
	
	String addCostOfGoodsSold(CostOfGoodsSoldDto costOfGoodsSoldDto);
	List<CostOfGoodsSoldDto> getAll();

}
