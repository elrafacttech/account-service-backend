package com.accountproject.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountproject.api.dto.OperatingExpensesTransactionDto;
import com.accountproject.api.entity.OperatingExpensesTransaction;
import com.accountproject.api.repository.OperatingExpensesTransactionRepo;
import com.accountproject.api.service.OperatingExpensesTransactionService;

@Service
public class OperatingExpensesTransactionServiceImpl implements OperatingExpensesTransactionService {

	@Autowired
	OperatingExpensesTransactionRepo transactionRepo;

	@Autowired()
	private ModelMapper modelMapper;

	@Override
	public String addOperatingExpensesTransaction(OperatingExpensesTransactionDto operatingExpensesTransactionDto) {
		OperatingExpensesTransaction transaction = modelMapper.map(operatingExpensesTransactionDto,
				OperatingExpensesTransaction.class);
//		transaction.setCode(operatingExpensesTransactionDto.getCode());
//		transaction.setCodeDescription(operatingExpensesTransactionDto.getCodeDescription());
//		transaction.setOperatingExpenses(operatingExpensesTransactionDto.getOperatingExpenses());
//		transaction.setOrganizationCode(operatingExpensesTransactionDto.getOrganizationCode());
//		transaction.setOperatingExpensesDate(LocalDateTime.now());
		transactionRepo.save(transaction);
		return "Saved Succeessful";
	}

	@Override
	public List<OperatingExpensesTransactionDto> getAll() {
		List<OperatingExpensesTransaction> transactions = transactionRepo.findAll();
		List<OperatingExpensesTransactionDto> response = new ArrayList<>();
		for (OperatingExpensesTransaction set : transactions) {
			OperatingExpensesTransactionDto map = modelMapper.map(set, OperatingExpensesTransactionDto.class);
			map.setBusinessid(set.getBusinessDetails().getBusinessId());
			response.add(map);
		}
		return response;
	}

	@Override
	public List<OperatingExpensesTransactionDto> getByBusinessId(int businessId) {
		List<OperatingExpensesTransaction> transactions = transactionRepo.getByBusinessId(businessId);
		List<OperatingExpensesTransactionDto> response = new ArrayList<>();
		for (OperatingExpensesTransaction set : transactions) {
			OperatingExpensesTransactionDto map = modelMapper.map(set, OperatingExpensesTransactionDto.class);
			map.setBusinessid(set.getBusinessDetails().getBusinessId());
			response.add(map);
		}
		return response;
	}

	@Override
	public List<OperatingExpensesTransactionDto> getProductByBusinessId(int businessId, int code) {
		List<OperatingExpensesTransaction> transactions = transactionRepo.getProductByBusinessId(businessId, code);
		List<OperatingExpensesTransactionDto> response = new ArrayList<>();
		for (OperatingExpensesTransaction set : transactions) {
			OperatingExpensesTransactionDto map = modelMapper.map(set, OperatingExpensesTransactionDto.class);
			map.setBusinessid(set.getBusinessDetails().getBusinessId());
			response.add(map);
		}
		return response;
	}

	@Override
	public List<OperatingExpensesTransactionDto> getDrCrByBusinessId(int businessId, int code, String drcr) {
		List<OperatingExpensesTransaction> transactions = transactionRepo.getDrCrByBusinessId(businessId, code, drcr);
		List<OperatingExpensesTransactionDto> response = new ArrayList<>();
		for (OperatingExpensesTransaction set : transactions) {
			OperatingExpensesTransactionDto map = modelMapper.map(set, OperatingExpensesTransactionDto.class);
			map.setBusinessid(set.getBusinessDetails().getBusinessId());
			response.add(map);
		}
		return response;
	}

	@Override
	public List<OperatingExpensesTransactionDto> getFromDateByBusinessId(int businessId, int code, String drcr,
			String fromDate) {
		List<OperatingExpensesTransaction> transactions = transactionRepo.getFromDateByBusinessId(businessId, code,
				drcr, fromDate);
		List<OperatingExpensesTransactionDto> response = new ArrayList<>();
		for (OperatingExpensesTransaction set : transactions) {
			OperatingExpensesTransactionDto map = modelMapper.map(set, OperatingExpensesTransactionDto.class);
			map.setBusinessid(set.getBusinessDetails().getBusinessId());
			response.add(map);
		}
		return response;
	}

	@Override
	public List<OperatingExpensesTransactionDto> getToDateByBusinessId(int businessId, int code, String drcr, String fromDate,
			String toDate) {
		List<OperatingExpensesTransaction> transactions = transactionRepo.getToDateByBusinessId(businessId, code, drcr,
				fromDate, toDate);
		List<OperatingExpensesTransactionDto> response = new ArrayList<>();
		for (OperatingExpensesTransaction set : transactions) {
			OperatingExpensesTransactionDto map = modelMapper.map(set, OperatingExpensesTransactionDto.class);
			map.setBusinessid(set.getBusinessDetails().getBusinessId());
			response.add(map);
		}
		return response;
	}

	@Override
	public List<OperatingExpensesTransactionDto> filter(String businessId, String code, String drcr, String fromDate,
			String toDate) {
		List<OperatingExpensesTransaction> transactions = transactionRepo.getFilteredTransactions(businessId, code, drcr,
				fromDate, toDate);
		List<OperatingExpensesTransactionDto> response = new ArrayList<>();
		for (OperatingExpensesTransaction set : transactions) {
			OperatingExpensesTransactionDto map = modelMapper.map(set, OperatingExpensesTransactionDto.class);
			map.setBusinessid(set.getBusinessDetails().getBusinessId());
			response.add(map);
		}
		return response;
	}

	@Override
	public List<OperatingExpensesTransactionDto> getProdcut() {
		List<OperatingExpensesTransaction> transactions = transactionRepo.getProduct();
		List<OperatingExpensesTransactionDto> response = new ArrayList<>();
		for (OperatingExpensesTransaction set : transactions) {
			OperatingExpensesTransactionDto map = modelMapper.map(set, OperatingExpensesTransactionDto.class);
			map.setBusinessid(set.getBusinessDetails().getBusinessId());
			response.add(map);
		}
		return response;
	}

}
