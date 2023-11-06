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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "revenue_transaction")
@EqualsAndHashCode(callSuper = false)
public class RevenueTransaction extends CodeDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "revenue_transaction_id")
	private Integer revenueTransactionId;
	@Column(name = "organization_code", length = 200)
	private String organizationCode;
	@Column(name = "revenue")
	private Double revenue;
	@Column(name = "revenue_date")
	@DateTimeFormat(pattern = "yyyy-mm-dd HH:MM:SS")
	private LocalDateTime revenueDate;
}
