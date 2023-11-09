package com.accountproject.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountproject.api.dto.res.CogstSumResDto;
import com.accountproject.api.dto.res.IncomeStatementRes;
import com.accountproject.api.dto.res.OperatingExpTranSumResDto;
import com.accountproject.api.dto.res.RevenueSumDto;
import com.accountproject.api.entity.IncomeStatement;
import com.accountproject.api.repo.CostOfGoodsSoldTransactionRepo;
import com.accountproject.api.repo.IncomeStatementRepo;
import com.accountproject.api.repo.OperatingExpensesTransactionRepo;
import com.accountproject.api.repo.RevenueTransactionRepo;
import com.accountproject.api.service.IncomeStatementService;

@Service
public class IncomeStatementServiceImpl implements IncomeStatementService {

	@Autowired
	IncomeStatementRepo incomeStatementRepo;

	@Autowired
	RevenueTransactionRepo revenueTransactionRepo;

	@Autowired
	CostOfGoodsSoldTransactionRepo goodsSoldTransactionRepo;

	@Autowired
	OperatingExpensesTransactionRepo expensesTransactionRepo;

	@Autowired()
	private ModelMapper modelMapper;

	@Override
	public IncomeStatementRes addIncomeStmt() {
		List<RevenueSumDto> revenueList = getRevenueSum();
		List<CogstSumResDto> cogstList = getCogstSum();
		List<OperatingExpTranSumResDto> operatingExpList = getOperExpTransSum();
		IncomeStatement statement = new IncomeStatement();
		double revenuSum = 0;
		double cogsSum = 0;
		double operatingExpSum = 0;
		for (RevenueSumDto set : revenueList) {
			if (set.getRevenue() == null) {
				set.setRevenue(0D);
			}

			if (set.getCode() == 4010 || set.getCode() == 4020 || set.getCode() == 4030 || set.getCode() == 4040) {
				revenuSum = revenuSum + set.getRevenue();
				statement.setRevenues(revenuSum);
			} else if (set.getCode() == 4600) {
				statement.setInterestIncome(set.getRevenue());
			} else if (set.getCode() == 4700) {
				statement.setOtherIncome(set.getRevenue());
			} else if (set.getCode() == 4800) {
				statement.setFinanceChargeIncome((set.getRevenue()));
			} else if (set.getCode() == 4900) {
				statement.setSalesReturnsAndAllowances(set.getRevenue());
			} else if (set.getCode() == 4950) {
				statement.setSalesDiscounts(set.getRevenue());
			}

		}
		double totalRevenue = statement.getRevenues() + statement.getInterestIncome()
				+ statement.getFinanceChargeIncome() + statement.getSalesReturnsAndAllowances()
				+ statement.getSalesDiscounts();
		statement.setTotalRevenue(totalRevenue);
		for (CogstSumResDto set : cogstList) {
			if (set.getCostOfGoodsSold() == null) {
				set.setCostOfGoodsSold(0D);
			}
			if (set.getCode() == 5010 || set.getCode() == 5020 || set.getCode() == 5030 || set.getCode() == 5040) {
				cogsSum = cogsSum + set.getCostOfGoodsSold();
				statement.setCostOfProducts(cogsSum);
			} else if (set.getCode() == 5700) {
				statement.setFreight(set.getCostOfGoodsSold());
			} else if (set.getCode() == 5800) {
				statement.setInventoryAdjustments(set.getCostOfGoodsSold());
			} else if (set.getCode() == 5900) {
				statement.setPurchaseReturnsAndAllowances(set.getCostOfGoodsSold());
			} else if (set.getCode() == 5950) {
				statement.setReserved(set.getCostOfGoodsSold());
			}

		}
		double totalCOGS = statement.getCostOfProducts() + statement.getFreight() + statement.getInventoryAdjustments()
				+ statement.getPurchaseReturnsAndAllowances() + statement.getReserved();
		statement.setTotalCOGS(totalCOGS);

		for (OperatingExpTranSumResDto set : operatingExpList) {
			if (set.getOperatingExpenses() == null) {
				set.setOperatingExpenses(0D);
			}
			if (set.getCode() == 6010) {
				statement.setAdvertisingExpenses(set.getOperatingExpenses());
			} else if (set.getCode() == 6050) {
				statement.setAmortizationExpense(set.getOperatingExpenses());
			} else if (set.getCode() == 6100) {
				statement.setAutoExpense(set.getOperatingExpenses());
			} else if (set.getCode() == 6150) {
				statement.setBadDebtExpenses(set.getOperatingExpenses());
			} else if (set.getCode() == 6200) {
				statement.setBankCharge(set.getOperatingExpenses());
			} else if (set.getCode() == 6250) {
				statement.setCashOverAndShort(set.getOperatingExpenses());
			} else if (set.getCode() == 6300) {
				statement.setCommissionExpense(set.getOperatingExpenses());
			} else if (set.getCode() == 6350) {
				statement.setDepreciationExpense(set.getOperatingExpenses());
			} else if (set.getCode() == 6400) {
				statement.setEmployeeBenefitProgram(set.getOperatingExpenses());
			} else if (set.getCode() == 6550) {
				statement.setFreightExpense(set.getOperatingExpenses());
			} else if (set.getCode() == 6600) {
				statement.setGiftsExpense(set.getOperatingExpenses());
			} else if (set.getCode() == 6650) {
				statement.setInsuranceGeneral(set.getOperatingExpenses());
			} else if (set.getCode() == 6700) {
				statement.setInterestExpense(set.getOperatingExpenses());
			} else if (set.getCode() == 6750) {
				statement.setProfessionalFees(set.getOperatingExpenses());
			} else if (set.getCode() == 6800) {
				statement.setLicenseExpense(set.getOperatingExpenses());
			} else if (set.getCode() == 6850) {
				statement.setMaintenanceExpense(set.getOperatingExpenses());
			} else if (set.getCode() == 6900) {
				statement.setMealsAndEntertainment(set.getOperatingExpenses());
			} else if (set.getCode() == 6950) {
				statement.setOfficeExpense(set.getOperatingExpenses());
			}

			else if (set.getCode() == 7000) {
				statement.setPayrollTaxes(set.getOperatingExpenses());
			} else if (set.getCode() == 7050) {
				statement.setPrinting(set.getOperatingExpenses());
			} else if (set.getCode() == 7150) {
				statement.setPostage(set.getOperatingExpenses());
			} else if (set.getCode() == 7200) {
				statement.setLeaseRent(set.getOperatingExpenses());
			} else if (set.getCode() == 7250) {
				statement.setRepairsExpense(set.getOperatingExpenses());
			} else if (set.getCode() == 7300) {
				statement.setSalariesExpense(set.getOperatingExpenses());
			} else if (set.getCode() == 7350) {
				statement.setSuppliesExpense(set.getOperatingExpenses());
			} else if (set.getCode() == 7400) {
				statement.setTaxesAndFITExpense(set.getOperatingExpenses());
			} else if (set.getCode() == 7500) {
				statement.setUtilitiesExpense(set.getOperatingExpenses());
			} else if (set.getCode() == 7900) {
				statement.setGainOrLossOnSaleOfAssets(set.getOperatingExpenses());
			}
		}

		double totalOperatingExpenses = statement.getAdvertisingExpenses() + statement.getAutoExpense()
				+ statement.getBadDebtExpenses() + statement.getBankCharge() + statement.getCashOverAndShort()
				+ statement.getCommissionExpense() + statement.getEmployeeBenefitProgram()
				+ statement.getFreightExpense() + statement.getGiftsExpense() + statement.getInsuranceGeneral()
				+ statement.getProfessionalFees() + statement.getLicenseExpense() + statement.getMaintenanceExpense()
				+ statement.getMealsAndEntertainment() + statement.getOfficeExpense() + statement.getPayrollTaxes()
				+ statement.getPrinting() + statement.getPostage() + statement.getLeaseRent()
				+ statement.getRepairsExpense() + statement.getSalariesExpense() + statement.getSuppliesExpense()
				+ statement.getUtilitiesExpense() + statement.getGainOrLossOnSaleOfAssets();
		statement.setTotalOperatingExpenses(totalOperatingExpenses);
		statement.setEBITDA(
				statement.getTotalRevenue() - statement.getTotalCOGS() - statement.getTotalOperatingExpenses());
		statement.setEBIT(statement.getEBITDA() - statement.getDepreciationExpense());
		statement.setProfitBeforeTaxes(statement.getEBIT() - statement.getInterestExpense());
		statement.setNetProfitAfterTaxesNPAT(statement.getProfitBeforeTaxes() - statement.getTaxesAndFITExpense());
		statement.setNetIncAttToCommonShareholders(statement.getNetProfitAfterTaxesNPAT());
		incomeStatementRepo.save(statement);
		IncomeStatementRes statementRes = modelMapper.map(statement, IncomeStatementRes.class);
		return statementRes;
	}

	public List<RevenueSumDto> getRevenueSum() {
		List<Object[]> list = revenueTransactionRepo.getRevenueSum();
		List<RevenueSumDto> dtoList = list.stream()
				.map(array -> new RevenueSumDto((Integer) array[0], (Double) array[1], (String) array[2]))
				.collect(Collectors.toList());

		return dtoList;
	}

	public List<CogstSumResDto> getCogstSum() {
		List<Object[]> list = goodsSoldTransactionRepo.getCostOfGoodsSum();
		List<CogstSumResDto> dtoList = list.stream()
				.map(array -> new CogstSumResDto((Integer) array[0], (Double) array[1], (String) array[2]))
				.collect(Collectors.toList());

		return dtoList;
	}

	public List<OperatingExpTranSumResDto> getOperExpTransSum() {
		List<Object[]> list = expensesTransactionRepo.getOperatingExpensesSum();
		List<OperatingExpTranSumResDto> dtoList = list.stream()
				.map(array -> new OperatingExpTranSumResDto((Integer) array[0], (Double) array[1], (String) array[2]))
				.collect(Collectors.toList());

		return dtoList;
	}

}
