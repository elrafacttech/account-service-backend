package com.accountproject.api.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class CodeDetailsDto {
	
	private Integer code;

	private String codeDescription;
	
	private Integer businessid;
	
	private String drcr;

}
