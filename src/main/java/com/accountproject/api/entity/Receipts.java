package com.accountproject.api.entity;

import java.time.LocalDateTime;

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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "receipts")
@EqualsAndHashCode(callSuper = false)
public class Receipts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "receipt_id", insertable = false)
	private Integer receiptId;

	@Column(name = "payment_date")
	@DateTimeFormat(pattern = "yyyy-mm-dd HH:MM:SS")
	private LocalDateTime paymentDate;

	@Column(name = "receipt")
	private String receipt;

	@Column(name = "invoice")
	private String invoice;

	@Column(name = "customer")
	private String customer;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "amount_received")
	private double amountReceived;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "business_id", referencedColumnName = "business_id")
	private BusinessDetails businessDetails;

}
