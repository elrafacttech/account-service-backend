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
@Entity(name = "operating_expenses_transaction")
@EqualsAndHashCode(callSuper = false)
public class OperatingExpensesTransaction extends CodeDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "operating_expenses_trans_id")
	private Integer operatingExpensesTransId;
	@Column(name = "organization_code",length = 200)
	private String organizationCode;
	@Column(name = "operating_expenses")
	private Double operatingExpenses;
	@Column(name = "operating_expenses_date")
	@DateTimeFormat(pattern = "yyyy-mm-dd HH:MM:SS")
	private LocalDateTime operatingExpensesDate;

}
