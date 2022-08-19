package com.inventorycontrol.repository;

import com.inventorycontrol.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID> {

    boolean existsByProductName(String productName);
}
