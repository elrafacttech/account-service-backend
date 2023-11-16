package com.accountproject.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountproject.api.dto.RevenueDto;
import com.accountproject.api.entity.Revenue;
import com.accountproject.api.repository.RevenueRepo;
import com.accountproject.api.service.RevenueService;

@Service
public class RevenueServiceImpl implements RevenueService {

	@Autowired
	RevenueRepo revenueRepo;

	@Autowired()
	private ModelMapper modelMapper;

	@Override
	public String addRevenueDetails(RevenueDto revenueDto) {
		Revenue revenue = modelMapper.map(revenueDto, Revenue.class);
		//revenue.setCode(revenueDto.getCode());
		//revenue.setCodeDescription(revenueDto.getCodeDescription());
		revenueRepo.save(revenue);
		return "Saved Succeessful";
		
		
	}

	@Override
	public List<RevenueDto> getAll() {
		List<Revenue> revenues = revenueRepo.findAll();
		List<RevenueDto> response = new ArrayList<>();
		for (Revenue set : revenues) {
			RevenueDto map = modelMapper.map(set, RevenueDto.class);
			response.add(map);
		}
		return response;
	}

}
