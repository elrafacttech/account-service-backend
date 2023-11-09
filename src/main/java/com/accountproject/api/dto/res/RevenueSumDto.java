package com.accountproject.api.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RevenueSumDto {
	
	private int code;
	
	private Double revenue;
	
	private String codeDescription;

}
