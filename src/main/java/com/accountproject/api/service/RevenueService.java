package com.accountproject.api.service;

import java.util.List;

import com.accountproject.api.dto.RevenueDto;

public interface RevenueService {

	String addRevenueDetails(RevenueDto revenueDto);
	List<RevenueDto> getAll();
}
