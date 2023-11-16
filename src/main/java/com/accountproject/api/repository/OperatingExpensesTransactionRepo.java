package com.accountproject.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.accountproject.api.entity.OperatingExpensesTransaction;

@Repository
public interface OperatingExpensesTransactionRepo extends JpaRepository<OperatingExpensesTransaction, Integer> {

	@Query(value = " SELECT r.code AS revenue_code, SUM(rt.operating_expenses) AS operating_expenses, r.code_description\r\n"
			+ "FROM operating_expenses r\r\n" + "LEFT JOIN operating_expenses_transaction rt ON r.code = rt.code\r\n"
			+ "GROUP BY r.code ", nativeQuery = true)
	List<Object[]> getOperatingExpensesSum();

	@Query(value = " SELECT * FROM operating_expenses_transaction WHERE business_id = :businessId ", nativeQuery = true)
	List<OperatingExpensesTransaction> getByBusinessId(@PathVariable(value = "businessId") int businessId);

	@Query(value = " SELECT * FROM operating_expenses_transaction WHERE business_id = :businessId AND code =:productCode ", nativeQuery = true)
	List<OperatingExpensesTransaction> getProductByBusinessId(@PathVariable(value = "businessId") int businessId,
			@PathVariable(value = "productCode") int productCode);

	@Query(value = " SELECT * FROM operating_expenses_transaction WHERE business_id = :businessId AND code =:productCode"
			+ " And drcr =:drcr", nativeQuery = true)
	List<OperatingExpensesTransaction> getDrCrByBusinessId(@PathVariable(value = "businessId") int businessId,
			@PathVariable(value = "productCode") int productCode, @PathVariable(value = "drcr") String drcr);

	@Query(value = " SELECT * FROM operating_expenses_transaction WHERE business_id = :businessId AND code =:productCode"
			+ " AND drcr =:drcr AND DATE(operating_expenses_date) >= :fromDate", nativeQuery = true)
	List<OperatingExpensesTransaction> getFromDateByBusinessId(@PathVariable(value = "businessId") int businessId,
			@PathVariable(value = "productCode") int productCode, @PathVariable(value = "drcr") String drcr,
			@PathVariable(value = "fromDate") String fromDate);

	@Query(value = " SELECT * FROM operating_expenses_transaction WHERE business_id = :businessId AND code =:productCode"
			+ " AND drcr =:drcr AND DATE(operating_expenses_date) >= :fromDate AND DATE(operating_expenses_date) <= :toDate", nativeQuery = true)
	List<OperatingExpensesTransaction> getToDateByBusinessId(@PathVariable(value = "businessId") int businessId,
			@PathVariable(value = "productCode") int productCode, @PathVariable(value = "drcr") String drcr,
			@PathVariable(value = "fromDate") String fromDate, @PathVariable(value = "toDate") String toDate);
	
	@Query(value = "SELECT * FROM operating_expenses_transaction WHERE "
	        + "(:businessId IS NULL OR business_id = :businessId) "
	        + "AND (:productCode IS NULL OR code = :productCode) "
	        + "AND (:drcr IS NULL OR drcr = :drcr) "
	        + "AND (:fromDate IS NULL OR DATE(operating_expenses_date) >= :fromDate) "
	        + "AND (:toDate IS NULL OR DATE(operating_expenses_date) <= :toDate)", nativeQuery = true)
	List<OperatingExpensesTransaction> getFilteredTransactions(
			@PathVariable("businessId") String businessId,
			@PathVariable("productCode") String productCode,
			@PathVariable("drcr") String drcr,
			@PathVariable("fromDate") String fromDate,
			@PathVariable("toDate") String toDate);
	
	@Query(value = " SELECT * FROM operating_expenses_transaction GROUP BY code", nativeQuery = true)
	List<OperatingExpensesTransaction> getProduct();
}
