package com.accountproject.api.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "business_details")
public class BusinessDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "business_id")
	private Integer businessId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private Users users;
	
	@Column(name = "business_name")
	private String businessName; // organization name
	
	@Column(name = "period_start")
	private LocalDateTime periodStart;
	
	@Column(name = "period_end")
	private LocalDateTime periodEnd;
	
	@Column(name = "no_of_common_share")
	private String noOfCommonShareAtYearEnd; // Number of common share at year-end
	
	@Column(name = "no_of_preferred_shares")
	private String noOfPreferredSharesAtYearEnd; // Number of preferred shares at year-end
	
	@Column(name = "weighted_avg_comn_shares")
	private String weightedAvgNumOfComnSharesDuringThePeriod; // Weighted average number of common shares during the period
	
	@Column(name = "common_share_price")
	private String commonSharePriceAtThePeriodEnd; // Common share price at the period end
	
	@Column(name = "preferred_share_price")
	private String preferredSharePriceAtThePeriodEnd; // Preferred share price at the period end
	
	@Column(name = "number_of_employees")
	private Integer numberOfEmployees;

}
