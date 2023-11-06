package com.accountproject.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CostOfGoodsSoldDto extends CodeDetailsDto{

	private Integer costOfGoodsSoldId;
}
