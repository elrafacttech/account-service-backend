package com.accountproject.api.service;

import java.util.List;

import com.accountproject.api.dto.BusinessDetailsDto;

public interface BusinessDetailsService {
	
	BusinessDetailsDto addBusiness(BusinessDetailsDto businessDetailsDto);
	
	List<BusinessDetailsDto> getAllBusiness();

	BusinessDetailsDto getByBusinessId(int businessId);
}
