package com.accountproject.api.dto.res;

import lombok.Data;

@Data
public class SalesResDto {

	private Integer salesId;

	//@DateTimeFormat(pattern = "dd-Mon-yy")
	private String date;

	private String paymentReceipt; // cash/credit

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
