package com.accountproject.api.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperatingExpTranSumResDto {

	private int code;

	private Double operatingExpenses;
	
	private String codeDescription;

}
