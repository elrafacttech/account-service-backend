package com.accountproject.api.service;

import java.util.List;

import com.accountproject.api.dto.PurchaseDto;

public interface PurchaseService {
	
	List<PurchaseDto> findALLPurchase();
	PurchaseDto addPurchaseDetails(PurchaseDto purchaseDto);

}
