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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cost_of_goods_sold_transaction")
@EqualsAndHashCode(callSuper = false)
public class CostOfGoodsSoldTransaction extends CodeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cost_of_goods_sold_trans_id")
	private Integer costOfGoodsSoldTransId;
	@Column(name = "organization_code", length = 200)
	private String organizationCode;
	@Column(name = "cost_of_goods_sold")
	private Double costOfGoodsSold;
	@Column(name = "cost_of_goods_sold_date")
	@DateTimeFormat(pattern = "yyyy-mm-dd HH:MM:SS")
	private LocalDateTime costOfGoodsSoldDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "business_id", referencedColumnName = "business_id")
	private BusinessDetails businessDetails;
}
