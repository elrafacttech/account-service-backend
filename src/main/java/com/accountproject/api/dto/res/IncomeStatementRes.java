package com.accountproject.api.dto.res;

import lombok.Data;

@Data
public class IncomeStatementRes {
	
    private Integer incomeStatmentId;
	
	private Double revenues;
	
	private Double interestIncome;
	
	private Double otherIncome;
	
	private Double financeChargeIncome;
	
	private Double salesReturnsAndAllowances;
	
	private Double salesDiscounts;
	
	private Double totalRevenue;
	
	private Double costOfProducts;
	
	private Double freight;
	
	private Double inventoryAdjustments;
	
	private Double purchaseReturnsAndAllowances;
	
	private Double reserved;
	
	private Double totalCOGS;
	
	private Double advertisingExpenses ;
	
	private Double autoExpense;
	
	private Double badDebtExpenses;
	
	private Double bankCharge ;
	
	private Double cashOverAndShort ;
	
	private Double commissionExpense ;
	
	private Double employeeBenefitProgram;
	
	private Double freightExpense;
	
	private Double giftsExpense;
	
	private Double insuranceGeneral ;
	
	private Double professionalFees ;
	
	private Double licenseExpense;
	
	private Double maintenanceExpense ;
	
	private Double mealsAndEntertainment ;
	
	private Double officeExpense;
	
	private Double payrollTaxes;
	
	private Double printing ;
	
	private Double postage ;
	
	private Double leaseRent ;
	
	private Double repairsExpense ;
	
	private Double salariesExpense ;
	
	private Double suppliesExpense;
	
	private Double utilitiesExpense ;
	
	private Double gainOrlossOnSaleOfAssets ;
	
	private Double totalOperatingExpenses;
	
	private Double EBITDA; //EBITDA = Total Revenue-Total Cogs-Total Operating Expenses
	
	private Double amortizationExpense;
	
	private Double depreciationExpense;
	
	private Double EBIT; // EBIT = EBITDA-Depreciation-Amortisation
	
	private Double interestExpense;
	
	private Double profitBeforeTaxes;
	
	private Double taxesAndFITExpense;
	
	private Double netProfitAfterTaxesNPAT;
	
	private Double preferredDividends;
	
	private Double netIncAttToCommonShareholders; //Net income attributable to common shareholders


}
