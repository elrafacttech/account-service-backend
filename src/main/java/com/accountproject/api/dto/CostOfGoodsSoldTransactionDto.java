package com.accountproject.api.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CostOfGoodsSoldTransactionDto extends CodeDetailsDto{
	
	private Integer costOfGoodsSoldTransId;

	private String organizationCode;

	private Double costOfGoodsSold;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime costOfGoodsSoldDate;

}
