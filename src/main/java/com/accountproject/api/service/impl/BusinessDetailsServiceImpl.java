package com.accountproject.api.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountproject.api.dto.BusinessDetailsDto;
import com.accountproject.api.entity.BusinessDetails;
import com.accountproject.api.repository.BusinessDetailsRepo;
import com.accountproject.api.service.BusinessDetailsService;

@Service
public class BusinessDetailsServiceImpl implements BusinessDetailsService {
	
	@Autowired
	BusinessDetailsRepo detailsRepo;
	
	@Autowired()
	private ModelMapper modelMapper;

	@Override
	public BusinessDetailsDto addBusiness(BusinessDetailsDto businessDetailsDto) {
		BusinessDetails businessDetails = modelMapper.map(businessDetailsDto, BusinessDetails.class);
		detailsRepo.save(businessDetails);
		BusinessDetailsDto response = modelMapper.map(businessDetails, BusinessDetailsDto.class);
		return response;
	}

	@Override
	public List<BusinessDetailsDto> getAllBusiness() {
		List<BusinessDetails> businessDetails = detailsRepo.findAll();
	//	List<BusinessDetailsDto> response = modelMapper.map(businessDetails, BusinessDetailsDto.class);
		return null;
	}

	@Override
	public BusinessDetailsDto getByBusinessId(int businessId) {
		BusinessDetails businessDetails = detailsRepo.getByBusinessId(businessId);
		BusinessDetailsDto response = modelMapper.map(businessDetails, BusinessDetailsDto.class);
		return response;
	}

}
