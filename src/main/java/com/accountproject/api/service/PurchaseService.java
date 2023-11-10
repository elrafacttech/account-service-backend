package com.accountproject.api.service;

import java.util.List;

import com.accountproject.api.dto.PurchaseDto;
import com.accountproject.api.dto.res.PurchaseResDto;

public interface PurchaseService {
	
	List<PurchaseResDto> findALLPurchase();
	PurchaseDto addPurchaseDetails(PurchaseDto purchaseDto);

}
