package com.accountproject.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountproject.api.dto.PurchaseDto;
import com.accountproject.api.entity.Purchase;
import com.accountproject.api.repo.PurchaseRepo;
import com.accountproject.api.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	PurchaseRepo purchaseRepo;

	@Autowired(required = true)
	private ModelMapper modelMapper;

	@Override
	public List<PurchaseDto> findALLPurchase() {
		List<Purchase> purchases = purchaseRepo.findAll();
		List<PurchaseDto> response = new ArrayList<>();
		for (Purchase set : purchases) {
			PurchaseDto map = modelMapper.map(set, PurchaseDto.class);
			response.add(map);
		}
		return response;
	}

	@Override
	public PurchaseDto addPurchaseDetails(PurchaseDto purchaseDto) {
		Purchase purchase = modelMapper.map(purchaseDto, Purchase.class);
		purchaseRepo.save(purchase);
		PurchaseDto response = modelMapper.map(purchase, PurchaseDto.class);
		return response;
	}

}
