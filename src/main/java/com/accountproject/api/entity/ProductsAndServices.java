package com.accountproject.api.entity;

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
@Entity(name = "products_and_services")
public class ProductsAndServices {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id",insertable = false)
	private Integer categoryId;
	
	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "category_type")
	private String categoryType;
	
	@Column(name = "code")
	private String code;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "business_id", referencedColumnName = "business_id")
	private BusinessDetails businessDetails;

}
