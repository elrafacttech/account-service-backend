package com.accountproject.api.service;

import java.util.List;

import com.accountproject.api.dto.OperatingExpensesTransactionDto;

public interface OperatingExpensesTransactionService {
	String addOperatingExpensesTransaction(OperatingExpensesTransactionDto operatingExpensesTransactionDto);

	List<OperatingExpensesTransactionDto> getAll();

	List<OperatingExpensesTransactionDto> getByBusinessId(int businessId);

	List<OperatingExpensesTransactionDto> getProductByBusinessId(int businessId, int code);

	List<OperatingExpensesTransactionDto> getDrCrByBusinessId(int businessId, int code, String drcr);

	List<OperatingExpensesTransactionDto> getFromDateByBusinessId(int businessId, int code, String drcr, String fromDate);

	List<OperatingExpensesTransactionDto> getToDateByBusinessId(int businessId, int code, String drcr, String fromDate, String toDate);
	
	List<OperatingExpensesTransactionDto> filter(String businessId, String code, String drcr, String fromDate, String toDate);
	
	List<OperatingExpensesTransactionDto> getProdcut();
}
