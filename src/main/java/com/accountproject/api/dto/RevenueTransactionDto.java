package com.accountproject.api.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RevenueTransactionDto extends CodeDetailsDto {
	private Integer revenueTransactionId;

	private String organizationCode;

	private Double revenue;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime revenueDate;
}
