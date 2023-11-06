package com.accountproject.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RevenueDto extends CodeDetailsDto{

	private Integer revenueId;
}
