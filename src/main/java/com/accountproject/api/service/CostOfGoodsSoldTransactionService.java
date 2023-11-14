package com.accountproject.api.service;

import java.util.List;

import com.accountproject.api.dto.CostOfGoodsSoldTransactionDto;

public interface CostOfGoodsSoldTransactionService {

	String addCostOfGoodsSoldTransaction(CostOfGoodsSoldTransactionDto soldTransactionDto);

	List<CostOfGoodsSoldTransactionDto> getAll();

	List<CostOfGoodsSoldTransactionDto> getByBusinessId(int businessId);

	List<CostOfGoodsSoldTransactionDto> getProductByBusinessId(int businessId, int code);

	List<CostOfGoodsSoldTransactionDto> getDrCrByBusinessId(int businessId, int code, String drcr);

	List<CostOfGoodsSoldTransactionDto> getFromDateByBusinessId(int businessId, int code, String drcr, String fromDate);

	List<CostOfGoodsSoldTransactionDto> getToDateByBusinessId(int businessId, int code, String drcr, String fromDate,
			String toDate);

	List<CostOfGoodsSoldTransactionDto> filter(String businessId, String code, String drcr, String fromDate,
			String toDate);

	List<CostOfGoodsSoldTransactionDto> getProdcut();
}
