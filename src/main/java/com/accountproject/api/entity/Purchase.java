package com.accountproject.api.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "business_id", referencedColumnName = "business_id")
	private BusinessDetails businessDetails;

	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy-mm-dd HH:MM:SS")
	private Date date;

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
