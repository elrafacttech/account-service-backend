package com.accountproject.api.service;

import java.util.List;

import com.accountproject.api.dto.SalesDto;
import com.accountproject.api.dto.res.SalesResDto;

public interface SalesService {
	
	List<SalesResDto> getAllSalesList();
	SalesDto addSalesDetails(SalesDto salesDto);

}
