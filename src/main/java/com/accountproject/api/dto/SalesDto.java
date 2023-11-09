package com.accountproject.api.dto;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class SalesDto {

	private Integer salesId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date date;
	
	private String  paymentReceipt; // cash/credit

	private String invoice;

	private String customer;

	private String productName;

	private String productCategory;

	private Integer unitsSold;

	private Double unitPrice;

	private Double invoiceValue;

	private Boolean vatApplicable;

	private Double vat;

	private String otherTaxes;

	private Double grossSales;
}
