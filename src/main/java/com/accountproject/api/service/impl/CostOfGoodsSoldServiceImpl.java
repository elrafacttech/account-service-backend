package com.accountproject.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
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
	
	@Autowired()
	private ModelMapper modelMapper;
	
	@Override
	public String addCostOfGoodsSold(CostOfGoodsSoldDto costOfGoodsSoldDto) {
		CostOfGoodsSold costOfGoodsSold = modelMapper.map(costOfGoodsSoldDto, CostOfGoodsSold.class);
		//costOfGoodsSold.setCode(costOfGoodsSoldDto.getCode());
		//costOfGoodsSold.setCode(costOfGoodsSoldDto.getCode());
		costOfGoodsSoldRepo.save(costOfGoodsSold);
		return "Saved Succeessful";
	}

	@Override
	public List<CostOfGoodsSoldDto> getAll() {
		List<CostOfGoodsSold> goodsSolds = costOfGoodsSoldRepo.findAll();
		List<CostOfGoodsSoldDto> response = new ArrayList<>();
		for (CostOfGoodsSold set : goodsSolds) {
			CostOfGoodsSoldDto map = modelMapper.map(set, CostOfGoodsSoldDto.class);
			response.add(map);
		}
		return response;
	}

}
