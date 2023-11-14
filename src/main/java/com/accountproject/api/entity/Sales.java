package com.accountproject.api.entity;

import java.time.LocalDateTime;
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
@Entity(name = "sales")
public class Sales {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sales_id")
	private Integer salesId;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "business_id", referencedColumnName = "business_id")
	private BusinessDetails businessDetails;
	
	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy-mm-dd HH:MM:SS")
	private Date date;
	
	@Column(name = "payment_receipt")
	private String  paymentReceipt; // cash/credit
	
	@Column(name = "invoice")
	private String invoice;
	
	@Column(name = "customer")
	private String customer;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_category")
	private String productCategory;
	
	@Column(name = "units_sold")
	private Integer unitsSold;
	
	@Column(name = "unit_price")
	private Double unitPrice;
	
	@Column(name = "invoice_value")
	private Double invoiceValue;
	
	@Column(name = "vat_applicable")
	private Boolean vatApplicable;
	
	@Column(name = "vat")
	private Double vat;
	
	@Column(name = "other_taxes")
	private Double otherTaxes;
	
	@Column(name = "gross_sales")
	private Double grossSales;

}
