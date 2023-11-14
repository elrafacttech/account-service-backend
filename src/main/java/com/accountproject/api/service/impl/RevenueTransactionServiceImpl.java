package com.accountproject.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountproject.api.dto.RevenueTransactionDto;
import com.accountproject.api.dto.res.RevenueSumDto;
import com.accountproject.api.entity.RevenueTransaction;
import com.accountproject.api.repo.RevenueTransactionRepo;
import com.accountproject.api.service.RevenueTransactionService;

@Service
public class RevenueTransactionServiceImpl implements RevenueTransactionService {

	@Autowired
	RevenueTransactionRepo transactionRepo;

	@Autowired()
	private ModelMapper modelMapper;

	@Override
	public String addRevenueTransaction(RevenueTransactionDto revenueTransactionDto) {
		RevenueTransaction transaction = modelMapper.map(revenueTransactionDto, RevenueTransaction.class);
//		transaction.setCode(revenueTransactionDto.getCode());
//		transaction.setCodeDescription(revenueTransactionDto.getCodeDescription());
//		transaction.setRevenue(revenueTransactionDto.getRevenue());
//		transaction.setOrganizationCode(revenueTransactionDto.getOrganizationCode());
//		transaction.setRevenueDate(LocalDateTime.now());
		transactionRepo.save(transaction);
		return "Saved Succeessful";
	}

	@Override
	public List<RevenueTransactionDto> getAll() {
		List<RevenueTransaction> transactions = transactionRepo.findAll();
		List<RevenueTransactionDto> response = new ArrayList<>();
		for (RevenueTransaction set : transactions) {
			RevenueTransactionDto map = modelMapper.map(set, RevenueTransactionDto.class);
			response.add(map);
		}
		return response;
	}

	@Override
	public List<RevenueSumDto> getRevenue() {
		List<RevenueSumDto> revenueSumDtos = transactionRepo.getRevenue();
		return revenueSumDtos;
	}

	@Override
	public List<RevenueTransactionDto> getByBusinessId(int businessId) {
		List<RevenueTransaction> revenueDto = transactionRepo.getByBusinessId(businessId);
		List<RevenueTransactionDto> response = new ArrayList<>();
		for (RevenueTransaction set : revenueDto) {
			RevenueTransactionDto map = modelMapper.map(set, RevenueTransactionDto.class);
			map.setBusinessid(set.getBusinessDetails().getBusinessId());
			response.add(map);
		}
		return response;
	}

	@Override
	public List<RevenueTransactionDto> getProductByBusinessId(int businessId, int code) {
		List<RevenueTransaction> revenueDto = transactionRepo.getProductByBusinessId(businessId, code);
		List<RevenueTransactionDto> response = new ArrayList<>();
		for (RevenueTransaction set : revenueDto) {
			RevenueTransactionDto map = modelMapper.map(set, RevenueTransactionDto.class);
			map.setBusinessid(set.getBusinessDetails().getBusinessId());
			response.add(map);
		}
		return response;
	}

	@Override
	public List<RevenueTransactionDto> getDrCrByBusinessId(int businessId, int code, String drcr) {
		List<RevenueTransaction> revenueDto = transactionRepo.getDrCrByBusinessId(businessId, code, drcr);
		List<RevenueTransactionDto> response = new ArrayList<>();
		for (RevenueTransaction set : revenueDto) {
			RevenueTransactionDto map = modelMapper.map(set, RevenueTransactionDto.class);
			map.setBusinessid(set.getBusinessDetails().getBusinessId());
			response.add(map);
		}
		return response;
	}

	@Override
	public List<RevenueTransactionDto> getFromDateByBusinessId(int businessId, int code, String drcr, String fromDate) {
		List<RevenueTransaction> revenueDto = transactionRepo.getFromDateByBusinessId(businessId, code, drcr, fromDate);
		List<RevenueTransactionDto> response = new ArrayList<>();
		for (RevenueTransaction set : revenueDto) {
			RevenueTransactionDto map = modelMapper.map(set, RevenueTransactionDto.class);
			map.setBusinessid(set.getBusinessDetails().getBusinessId());
			response.add(map);
		}
		return response;
	}

	@Override
	public List<RevenueTransactionDto> getToDateByBusinessId(int businessId, int code, String drcr, String fromDate,
			String toDate) {
		List<RevenueTransaction> revenueDto = transactionRepo.getToDateByBusinessId(businessId, code, drcr, fromDate,
				toDate);
		List<RevenueTransactionDto> response = new ArrayList<>();
		for (RevenueTransaction set : revenueDto) {
			RevenueTransactionDto map = modelMapper.map(set, RevenueTransactionDto.class);
			map.setBusinessid(set.getBusinessDetails().getBusinessId());
			response.add(map);
		}
		return response;
	}

	@Override
	public List<RevenueTransactionDto> filter(String businessId, String code, String drcr, String fromDate,
			String toDate) {
		List<RevenueTransaction> revenueDto = transactionRepo.getFilteredTransactions(businessId, code, drcr, fromDate,
				toDate);
		List<RevenueTransactionDto> response = new ArrayList<>();
		for (RevenueTransaction set : revenueDto) {
			RevenueTransactionDto map = modelMapper.map(set, RevenueTransactionDto.class);
			map.setBusinessid(set.getBusinessDetails().getBusinessId());
			response.add(map);
		}
		return response;
	}

	@Override
	public List<RevenueTransactionDto> getProdcut() {
		List<RevenueTransaction> transactions = transactionRepo.getProduct();
		List<RevenueTransactionDto> response = new ArrayList<>();
		for (RevenueTransaction set : transactions) {
			RevenueTransactionDto map = modelMapper.map(set, RevenueTransactionDto.class);
			response.add(map);
		}
		return response;
	}

}
