package com.inventorycontrol.repository;

import com.inventorycontrol.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, UUID> {

    boolean existsByCategoryName(String categoryName);
}
