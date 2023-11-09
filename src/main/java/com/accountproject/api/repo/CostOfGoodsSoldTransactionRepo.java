package com.accountproject.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.accountproject.api.entity.CostOfGoodsSoldTransaction;

@Repository
public interface CostOfGoodsSoldTransactionRepo extends JpaRepository<CostOfGoodsSoldTransaction, Integer> {

	@Query(value = " SELECT r.code AS revenue_code, SUM(rt.cost_of_goods_sold) AS cost_of_goods_sold, r.code_description\r\n"
			+ "FROM cost_of_goods_sold r\r\n" + "LEFT JOIN cost_of_goods_sold_transaction rt ON r.code = rt.code\r\n"
			+ "GROUP BY r.code ", nativeQuery = true)
	List<Object[]> getCostOfGoodsSum();

	@Query(value = " SELECT * FROM cost_of_goods_sold_transaction WHERE business_id = :businessId ", nativeQuery = true)
	List<CostOfGoodsSoldTransaction> getByBusinessId(@PathVariable(value = "businessId") int businessId);

	@Query(value = " SELECT * FROM cost_of_goods_sold_transaction WHERE business_id = :businessId AND code =:productCode ", nativeQuery = true)
	List<CostOfGoodsSoldTransaction> getProductByBusinessId(@PathVariable(value = "businessId") int businessId,
			@PathVariable(value = "productCode") int productCode);

	@Query(value = " SELECT * FROM cost_of_goods_sold_transaction WHERE business_id = :businessId AND code =:productCode"
			+ " And drcr =:drcr", nativeQuery = true)
	List<CostOfGoodsSoldTransaction> getDrCrByBusinessId(@PathVariable(value = "businessId") int businessId,
			@PathVariable(value = "productCode") int productCode, @PathVariable(value = "drcr") String drcr);

	@Query(value = " SELECT * FROM cost_of_goods_sold_transaction WHERE business_id = :businessId AND code =:productCode"
			+ " AND drcr =:drcr AND DATE(cost_of_goods_sold_date) >= :fromDate", nativeQuery = true)
	List<CostOfGoodsSoldTransaction> getFromDateByBusinessId(@PathVariable(value = "businessId") int businessId,
			@PathVariable(value = "productCode") int productCode, @PathVariable(value = "drcr") String drcr,
			@PathVariable(value = "fromDate") String fromDate);

	@Query(value = " SELECT * FROM cost_of_goods_sold_transaction WHERE business_id = :businessId AND code =:productCode"
			+ " AND drcr =:drcr AND DATE(cost_of_goods_sold_date) >= :fromDate AND DATE(cost_of_goods_sold_date) <= :toDate", nativeQuery = true)
	List<CostOfGoodsSoldTransaction> getToDateByBusinessId(@PathVariable(value = "businessId") int businessId,
			@PathVariable(value = "productCode") int productCode, @PathVariable(value = "drcr") String drcr,
			@PathVariable(value = "fromDate") String fromDate, @PathVariable(value = "toDate") String toDate);
}
