package com.accountproject.api.dto.res;

import lombok.Data;

@Data
public class PurchaseResDto {
	
	private Integer purchaseId;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private String date;

	private String paymentReceipt; // cash/credit

	private String productName;

	private String productCategory;

	private Integer unitsPurchased;

	private Double unitCost;

	private Double invoiceCost;

	private Boolean vatApplicable;

	private Double vat;

	private String otherTaxes;

	private Double totalCost;

}
