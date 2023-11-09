package com.accountproject.api.entity;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "inventories_balance_master")
public class InventoriesBalanceMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "invent_balance_master_id", insertable = false)
	private Integer inventBalanceMasterId;

	@Column(name = "balance_date")
	@DateTimeFormat(pattern = "yyyy-mm-dd HH:MM:SS")
	private LocalDateTime balanceDate;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "units")
	private Integer units;

	@Column(name = "cost_per_unit")
	private Float costPerUnit;

	@Column(name = "total_cost")
	private Double totalCost;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "business_id", referencedColumnName = "business_id")
	private BusinessDetails businessDetails;

}
