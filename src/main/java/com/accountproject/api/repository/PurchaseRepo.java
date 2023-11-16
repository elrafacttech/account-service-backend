package com.accountproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accountproject.api.entity.Purchase;

@Repository
public interface PurchaseRepo extends JpaRepository<Purchase, Integer>{

}
