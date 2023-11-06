package com.accountproject.api.entity;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "purchase")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchase_id")
	private Integer purchaseId;

	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy-mm-dd HH:MM:SS")
	private LocalDateTime date;

	@Column(name = "payment_receipt")
	private String paymentReceipt; // cash/credit

	// private String invoice;

	// private String customer;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_category")
	private String productCategory;

	@Column(name = "units_purchased")
	private Integer unitsPurchased;

	@Column(name = "unit_cost")
	private Double unitCost;

	@Column(name = "invoice_cost")
	private Double invoiceCost;

	@Column(name = "vat_applicable")
	private Boolean vatApplicable;

	@Column(name = "vat")
	private Double vat;

	@Column(name = "other_taxes")
	private String otherTaxes;

	@Column(name = "total_cost")
	private Double totalCost;

}
