package com.accountproject.api.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountproject.api.dto.SalesDto;
import com.accountproject.api.dto.res.SalesResDto;
import com.accountproject.api.entity.Sales;
import com.accountproject.api.repo.SalesRepo;
import com.accountproject.api.service.SalesService;

@Service
public class SalesServiceImpl implements SalesService {

	@Autowired
	SalesRepo salesRepo;

	@Autowired()
	private ModelMapper modelMapper;

	@Override
	public List<SalesResDto> getAllSalesList() {
		List<Sales> sales = salesRepo.findAll();
		List<SalesResDto> response = new ArrayList<>();
		 SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yy");
		for (Sales set : sales) {
			SalesResDto map = modelMapper.map(set, SalesResDto.class);
			String formattedDate = dateFormatter.format(set.getDate());
			map.setDate(formattedDate);
			response.add(map);
		}
		return response;
	}

	@Override
	public SalesDto addSalesDetails(SalesDto salesDto) {
		Sales sales = modelMapper.map(salesDto, Sales.class);
		salesRepo.save(sales);
		SalesDto response = modelMapper.map(sales, SalesDto.class);
		return response;
	}

}
