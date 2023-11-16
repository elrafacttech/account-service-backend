package com.accountproject.api.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountproject.api.dto.PurchaseDto;
import com.accountproject.api.dto.res.PurchaseResDto;
import com.accountproject.api.entity.Purchase;
import com.accountproject.api.repository.PurchaseRepo;
import com.accountproject.api.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	PurchaseRepo purchaseRepo;

	@Autowired(required = true)
	private ModelMapper modelMapper;

	@Override
	public List<PurchaseResDto> findALLPurchase() {
		List<Purchase> purchases = purchaseRepo.findAll();
		List<PurchaseResDto> response = new ArrayList<>();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yy");
		for (Purchase set : purchases) {
			PurchaseResDto map = modelMapper.map(set, PurchaseResDto.class);
			String formattedDate = dateFormatter.format(set.getDate());
			map.setDate(formattedDate);
			response.add(map);
		}
		return response;
	}

	@Override
	public PurchaseDto addPurchaseDetails(PurchaseDto purchaseDto) {
		Purchase purchase = modelMapper.map(purchaseDto, Purchase.class);
		purchase.setInvoiceCost(purchaseDto.getUnitsPurchased() * purchaseDto.getUnitCost());
		if (purchaseDto.getVat() == null || purchaseDto.getVat() == 0)
			purchaseDto.setVat(0.0);
		if (purchaseDto.getOtherTaxes() == null || purchaseDto.getOtherTaxes() == 0)
			purchaseDto.setOtherTaxes(0.0);
		purchase.setTotalCost(purchaseDto.getVat() + purchase.getInvoiceCost() + purchaseDto.getOtherTaxes());
		Date date = new Date();
		purchase.setDate(date);
		purchaseRepo.save(purchase);
		PurchaseDto response = modelMapper.map(purchase, PurchaseDto.class);
		return response;
	}

}
