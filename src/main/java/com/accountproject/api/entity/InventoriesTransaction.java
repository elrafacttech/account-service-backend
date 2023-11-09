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
@Entity(name = "inventories_transaction")
public class InventoriesTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "invent_trans_id", insertable = false)
	private Integer inventTransId;

	@Column(name = "transaction_date")
	@DateTimeFormat(pattern = "yyyy-mm-dd HH:MM:SS")
	private LocalDateTime transactionDate;

	@Column(name = "purchase")
	private Float purchase;

	@Column(name = "sale")
	private Float sale;

	@Column(name = "total")
	private Double total;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "invent_trans_master_id", referencedColumnName = "invent_trans_master_id")
	private InventoriesTransactionMaster transactionMaster;
	
}
