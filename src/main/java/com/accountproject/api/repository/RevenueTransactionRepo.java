package com.accountproject.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.accountproject.api.dto.res.RevenueSumDto;
import com.accountproject.api.entity.RevenueTransaction;

@Repository
public interface RevenueTransactionRepo extends JpaRepository<RevenueTransaction, Integer> {
	
	@Query(value = " SELECT r.code AS revenue_code, SUM(rt.revenue) AS total_revenue, r.code_description\r\n"
			+ "FROM revenue r\r\n"
			+ "LEFT JOIN revenue_transaction rt ON r.code = rt.code\r\n"
			+ "GROUP BY r.code ", nativeQuery = true)
	List<Object[]> getRevenueSum();
	
	@Query(value = " SELECT code, SUM(revenue) FROM revenue_transaction GROUP BY code", nativeQuery = true)
	List<RevenueSumDto> getRevenue();
	
	@Query(value = " SELECT * FROM revenue_transaction WHERE business_id = :businessId ", nativeQuery = true)
	List<RevenueTransaction> getByBusinessId(@PathVariable(value = "businessId") int businessId);
	
	@Query(value = " SELECT * FROM revenue_transaction WHERE business_id = :businessId AND code =:productCode ", nativeQuery = true)
	List<RevenueTransaction> getProductByBusinessId(@PathVariable(value = "businessId") int businessId,
			@PathVariable(value = "productCode") int productCode);
	
	@Query(value = " SELECT * FROM revenue_transaction WHERE business_id = :businessId AND code =:productCode"
			+ " And drcr =:drcr", nativeQuery = true)
	List<RevenueTransaction> getDrCrByBusinessId(@PathVariable(value = "businessId") int businessId,
			@PathVariable(value = "productCode") int productCode,@PathVariable(value = "drcr") String drcr);
	
	@Query(value = " SELECT * FROM revenue_transaction WHERE business_id = :businessId AND code =:productCode"
			+ " AND drcr =:drcr AND DATE(revenue_date) >=:fromDate", nativeQuery = true)
	List<RevenueTransaction> getFromDateByBusinessId(@PathVariable(value = "businessId") int businessId,
			@PathVariable(value = "productCode") int productCode,@PathVariable(value = "drcr") String drcr,
			@PathVariable(value = "fromDate") String fromDate);
	
	@Query(value = " SELECT * FROM revenue_transaction WHERE business_id = :businessId AND code =:productCode"
			+ " AND drcr =:drcr AND DATE(revenue_date) >=:fromDate AND DATE(revenue_date) <=:toDate", nativeQuery = true)
	List<RevenueTransaction> getToDateByBusinessId(@PathVariable(value = "businessId") int businessId,
			@PathVariable(value = "productCode") int productCode,@PathVariable(value = "drcr") String drcr,
			@PathVariable(value = "fromDate") String fromDate,@PathVariable(value = "toDate") String toDate);
	
	@Query(value = "SELECT * FROM revenue_transaction WHERE "
	        + "(:businessId IS NULL OR business_id = :businessId) "
	        + "AND (:productCode IS NULL OR code = :productCode) "
	        + "AND (:drcr IS NULL OR drcr = :drcr) "
	        + "AND (:fromDate IS NULL OR DATE(revenue_date) >= :fromDate) "
	        + "AND (:toDate IS NULL OR DATE(revenue_date) <= :toDate)", nativeQuery = true)
	List<RevenueTransaction> getFilteredTransactions(
			@PathVariable("businessId") String businessId,
			@PathVariable("productCode") String productCode,
			@PathVariable("drcr") String drcr,
			@PathVariable("fromDate") String fromDate,
			@PathVariable("toDate") String toDate);
	
	@Query(value = " SELECT * FROM revenue_transaction GROUP BY code", nativeQuery = true)
	List<RevenueTransaction> getProduct();
}
