package com.accountproject.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountproject.api.dto.CostOfGoodsSoldTransactionDto;
import com.accountproject.api.entity.CostOfGoodsSoldTransaction;
import com.accountproject.api.repo.CostOfGoodsSoldTransactionRepo;
import com.accountproject.api.service.CostOfGoodsSoldTransactionService;

@Service
public class CostOfGoodsSoldTransactionServiceImpl implements CostOfGoodsSoldTransactionService {

	@Autowired
	CostOfGoodsSoldTransactionRepo soldTransactionRepo;

	@Autowired()
	private ModelMapper modelMapper;

	@Override
	public String addCostOfGoodsSoldTransaction(CostOfGoodsSoldTransactionDto soldTransactionDto) {
		CostOfGoodsSoldTransaction transaction = modelMapper.map(soldTransactionDto, CostOfGoodsSoldTransaction.class);
		// transaction.setCode(soldTransactionDto.getCode());
		// transaction.setCodeDescription(soldTransactionDto.getCodeDescription());
		// transaction.setCostOfGoodsSold(soldTransactionDto.getCostOfGoodsSold());
		// transaction.setOrganizationCode(soldTransactionDto.getOrganizationCode());
		// transaction.setCostOfGoodsSoldDate(LocalDateTime.now());
		soldTransactionRepo.save(transaction);
		return "Saved Succeessful";
	}

	@Override
	public List<CostOfGoodsSoldTransactionDto> getAll() {
		List<CostOfGoodsSoldTransaction> transactions = soldTransactionRepo.findAll();
		List<CostOfGoodsSoldTransactionDto> response = new ArrayList<>();
		for (CostOfGoodsSoldTransaction set : transactions) {
			CostOfGoodsSoldTransactionDto map = modelMapper.map(set, CostOfGoodsSoldTransactionDto.class);
			map.setBusinessid(set.getBusinessDetails().getBusinessId());
			response.add(map);
		}
		return response;
	}

	@Override
	public List<CostOfGoodsSoldTransactionDto> getByBusinessId(int businessId) {
		List<CostOfGoodsSoldTransaction> transactions = soldTransactionRepo.getByBusinessId(businessId);
		List<CostOfGoodsSoldTransactionDto> response = new ArrayList<>();
		for (CostOfGoodsSoldTransaction set : transactions) {
			CostOfGoodsSoldTransactionDto map = modelMapper.map(set, CostOfGoodsSoldTransactionDto.class);
			map.setBusinessid(set.getBusinessDetails().getBusinessId());
			response.add(map);
		}
		return response;
	}

	@Override
	public List<CostOfGoodsSoldTransactionDto> getProductByBusinessId(int businessId, int code) {
		List<CostOfGoodsSoldTransaction> transactions = soldTransactionRepo.getProductByBusinessId(businessId, code);
		List<CostOfGoodsSoldTransactionDto> response = new ArrayList<>();
		for (CostOfGoodsSoldTransaction set : transactions) {
			CostOfGoodsSoldTransactionDto map = modelMapper.map(set, CostOfGoodsSoldTransactionDto.class);
			map.setBusinessid(set.getBusinessDetails().getBusinessId());
			response.add(map);
		}
		return response;
	}

	@Override
	public List<CostOfGoodsSoldTransactionDto> getDrCrByBusinessId(int businessId, int code, String drcr) {
		List<CostOfGoodsSoldTransaction> transactions = soldTransactionRepo.getDrCrByBusinessId(businessId, code, drcr);
		List<CostOfGoodsSoldTransactionDto> response = new ArrayList<>();
		for (CostOfGoodsSoldTransaction set : transactions) {
			CostOfGoodsSoldTransactionDto map = modelMapper.map(set, CostOfGoodsSoldTransactionDto.class);
			map.setBusinessid(set.getBusinessDetails().getBusinessId());
			response.add(map);
		}
		return response;
	}

	@Override
	public List<CostOfGoodsSoldTransactionDto> getFromDateByBusinessId(int businessId, int code, String drcr,
			String fromDate) {
		List<CostOfGoodsSoldTransaction> transactions = soldTransactionRepo.getFromDateByBusinessId(businessId, code,
				drcr, fromDate);
		List<CostOfGoodsSoldTransactionDto> response = new ArrayList<>();
		for (CostOfGoodsSoldTransaction set : transactions) {
			CostOfGoodsSoldTransactionDto map = modelMapper.map(set, CostOfGoodsSoldTransactionDto.class);
			map.setBusinessid(set.getBusinessDetails().getBusinessId());
			response.add(map);
		}
		return response;
	}

	@Override
	public List<CostOfGoodsSoldTransactionDto> getToDateByBusinessId(int businessId, int code, String drcr,
			String fromDate, String toDate) {
		List<CostOfGoodsSoldTransaction> transactions = soldTransactionRepo.getToDateByBusinessId(businessId, code,
				drcr, fromDate, toDate);
		List<CostOfGoodsSoldTransactionDto> response = new ArrayList<>();
		for (CostOfGoodsSoldTransaction set : transactions) {
			CostOfGoodsSoldTransactionDto map = modelMapper.map(set, CostOfGoodsSoldTransactionDto.class);
			map.setBusinessid(set.getBusinessDetails().getBusinessId());
			response.add(map);
		}
		return response;
	}

	@Override
	public List<CostOfGoodsSoldTransactionDto> filter(String businessId, String code, String drcr, String fromDate,
			String toDate) {
		List<CostOfGoodsSoldTransaction> transactions = soldTransactionRepo.getFilteredTransactions(businessId, code,
				drcr, fromDate, toDate);
		List<CostOfGoodsSoldTransactionDto> response = new ArrayList<>();
		for (CostOfGoodsSoldTransaction set : transactions) {
			CostOfGoodsSoldTransactionDto map = modelMapper.map(set, CostOfGoodsSoldTransactionDto.class);
			map.setBusinessid(set.getBusinessDetails().getBusinessId());
			response.add(map);
		}
		return response;
	}

	@Override
	public List<CostOfGoodsSoldTransactionDto> getProdcut() {
		List<CostOfGoodsSoldTransaction> transactions = soldTransactionRepo.getProduct();
		List<CostOfGoodsSoldTransactionDto> response = new ArrayList<>();
		for (CostOfGoodsSoldTransaction set : transactions) {
			CostOfGoodsSoldTransactionDto map = modelMapper.map(set, CostOfGoodsSoldTransactionDto.class);
			map.setBusinessid(set.getBusinessDetails().getBusinessId());
			response.add(map);
		}
		return response;
	}

}
