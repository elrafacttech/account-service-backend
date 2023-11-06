package com.accountproject.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "income_statement")
public class IncomeStatement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "income_statment_id")
	private Integer incomeStatmentId;
	
	@Column(name = "revenues")
	private Double revenues;
	
	@Column(name = "interest_income")
	private Double interestIncome;
	
	@Column(name = "other_income")
	private Double otherIncome;
	
	@Column(name = "finance_charge_income")
	private Double financeChargeIncome;
	
	@Column(name = "sales_returns_and_allowances")
	private Double salesReturnsAndAllowances;
	
	@Column(name = "sales_discounts")
	private Double salesDiscounts;
	
	@Column(name = "total_revenue")
	private Double totalRevenue;
	
	@Column(name = "cost_of_products")
	private Double costOfProducts;
	
	@Column(name = "freight")
	private Double freight;
	
	@Column(name = "inventory_adjustments")
	private Double inventoryAdjustments;
	
	@Column(name = "purchase_returns_and_allowances")
	private Double purchaseReturnsAndAllowances;
	
	@Column(name = "reserved")
	private Double reserved;
	
	@Column(name = "total_cogs")
	private Double totalCOGS;
	
	@Column(name = "advertising_expenses")
	private Double advertisingExpenses ;
	
	@Column(name = "auto_expense")
	private Double autoExpense;
	
	@Column(name = "bad_bebt_expenses")
	private Double badDebtExpenses;
	
	@Column(name = "bank_charge")
	private Double bankCharge ;
	
	@Column(name = "cash_over_and_short")
	private Double cashOverAndShort ;
	
	@Column(name = "commission_expense")
	private Double commissionExpense ;
	
	@Column(name = "employee_benefit_program")
	private Double employeeBenefitProgram;
	
	@Column(name = "freight_expense")
	private Double freightExpense;
	
	@Column(name = "gifts_expense")
	private Double giftsExpense;
	
	@Column(name = "insurance_general")
	private Double insuranceGeneral ;
	
	@Column(name = "professional_fees")
	private Double professionalFees ;
	
	@Column(name = "license_expense")
	private Double licenseExpense;
	
	@Column(name = "maintenance_expense")
	private Double maintenanceExpense ;
	
	@Column(name = "meals_and_entertainment")
	private Double mealsAndEntertainment ;
	
	@Column(name = "office_expense")
	private Double officeExpense;
	
	@Column(name = "payroll_taxes")
	private Double payrollTaxes;
	
	@Column(name = "printing")
	private Double printing ;
	
	@Column(name = "postage")
	private Double postage ;
	
	@Column(name = "lease_rent")
	private Double leaseRent ;
	
	@Column(name = "repairs_expense")
	private Double repairsExpense ;
	
	@Column(name = "salaries_expense")
	private Double salariesExpense ;
	
	@Column(name = "supplies_expense")
	private Double suppliesExpense;
	
	@Column(name = "utilities_expense")
	private Double utilitiesExpense ;
	
	@Column(name = "gain_or_loss_on_sale_of_assets")
	private Double gainOrLossOnSaleOfAssets ;
	
	@Column(name = "total_operating_expenses")
	private Double totalOperatingExpenses;
	
	@Column(name = "ebitda")
	private Double EBITDA; //EBITDA = Total Revenue-Total Cogs-Total Operating Expenses
	
	@Column(name = "amortization_expense")
	private Double amortizationExpense;
	
	@Column(name = "depreciation_expense")
	private Double depreciationExpense;
	
	@Column(name = "ebit")
	private Double EBIT; // EBIT = EBITDA-Depreciation-Amortisation
	
	@Column(name = "interest_expense")
	private Double interestExpense;
	
	@Column(name = "profit_before_taxes")
	private Double profitBeforeTaxes;
	
	@Column(name = "taxes_and_fite_expense")
	private Double taxesAndFITExpense;
	
	@Column(name = "net_profit_after_taxes_npat")
	private Double netProfitAfterTaxesNPAT;
	
	@Column(name = "preferred_dividends")
	private Double preferredDividends;
	
	@Column(name = "net_inc_att_to_common_shareholders")
	private Double netIncAttToCommonShareholders; //Net income attributable to common shareholders
}
