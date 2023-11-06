package com.accountproject.api.dto.res;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BusinessDetailsRes {

	private Integer businessId;

	private String businessName; // organization name

	private LocalDateTime periodStart;

	private LocalDateTime periodEnd;

	private String noOfCommonShareAtYearEnd; // Number of common share at year-end

	private String noOfPreferredSharesAtYearEnd; // Number of preferred shares at year-end

	private String weightedAvgNumOfComnSharesDuringThePeriod; // Weighted average number of common shares during the
																// period

	private String commonSharePriceAtThePeriodEnd; // Common share price at the period end

	private String preferredSharePriceAtThePeriodEnd; // Preferred share price at the period end

	private String numberOfEmployees;

}
