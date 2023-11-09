package com.accountproject.api.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CogstSumResDto {

	private int code;

	private Double costOfGoodsSold;
	
	private String codeDescription;

}
