package com.accountproject.api.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OperatingExpensesTransactionDto extends CodeDetailsDto {
	private Integer operatingExpensesTransId;

	private String organizationCode;

	private Double operatingExpenses;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime operatingExpensesDate;
}
