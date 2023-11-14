package com.accountproject.api.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PurchaseDto {

	private Integer purchaseId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date date;

	private String paymentReceipt; // cash/credit

	private String productName;

	private String productCategory;

	private Integer unitsPurchased;

	private Double unitCost;

	private Double invoiceCost;

	private Boolean vatApplicable;

	private Double vat;

	private Double otherTaxes;

	private Double totalCost;

}
