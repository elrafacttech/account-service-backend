package com.accountproject.api.service;

import java.util.List;

import com.accountproject.api.dto.RevenueTransactionDto;
import com.accountproject.api.dto.res.RevenueSumDto;

public interface RevenueTransactionService {
	String addRevenueTransaction(RevenueTransactionDto revenueTransactionDto);

	List<RevenueTransactionDto> getAll();

	List<RevenueSumDto> getRevenue();

	List<RevenueTransactionDto> getByBusinessId(int businessId);

	List<RevenueTransactionDto> getProductByBusinessId(int businessId, int code);

	List<RevenueTransactionDto> getDrCrByBusinessId(int businessId, int code, String drcr);

	List<RevenueTransactionDto> getFromDateByBusinessId(int businessId, int code, String drcr, String fromDate);

	List<RevenueTransactionDto> getToDateByBusinessId(int businessId, int code, String drcr, String fromDate, String toDate);
	
	List<RevenueTransactionDto> filter(String businessId, String code, String drcr, String fromDate, String toDate);
	
	List<RevenueTransactionDto> getProdcut();

}
