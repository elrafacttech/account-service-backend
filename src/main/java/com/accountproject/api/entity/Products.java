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
@Entity(name = "products")
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id",insertable = false)
	private Integer productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_name", referencedColumnName = "category_name")
	private ProductsAndServices productsAndServices;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "business_id", referencedColumnName = "business_id")
	private BusinessDetails businessDetails;
	

}
