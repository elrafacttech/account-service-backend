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
@Entity(name = "inventories_balance")
public class InventoriesBalance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "invent_balance_id", insertable = false)
	private Integer inventBalanceId;

	@Column(name = "balance_date")
	@DateTimeFormat(pattern = "yyyy-mm-dd HH:MM:SS")
	private LocalDateTime balanceDate;

	@Column(name = "opening")
	private Integer opening;

	@Column(name = "purchase")
	private Float purchase;

	@Column(name = "sale")
	private Float sale;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "invent_balance_master_id", referencedColumnName = "invent_balance_master_id")
	private InventoriesBalanceMaster balanceMaster;

}
