package com.accountproject.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountproject.api.dto.RevenueDto;
import com.accountproject.api.entity.Revenue;
import com.accountproject.api.repo.RevenueRepo;
import com.accountproject.api.service.RevenueService;

@Service
public class RevenueServiceImpl implements RevenueService {
	
	@Autowired
	RevenueRepo revenueRepo;

	@Override
	public String addRevenueDetails(RevenueDto revenueDto) {
		Revenue revenue = new Revenue();
		revenue.setCode(revenueDto.getCode());
		revenue.setCodeDescription(revenueDto.getCodeDescription());
		revenueRepo.save(revenue);
		return "Saved Succeessful";
	}
	
	

}
