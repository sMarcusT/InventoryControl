package com.inventorycontrol.service;

import com.inventorycontrol.exception.DataAlreadyRegisteredException;
import com.inventorycontrol.model.CategoryModel;
import com.inventorycontrol.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryModel> findAll() {
        return categoryRepository.findAll();
    }

    public CategoryModel findById(UUID uuid) {
        return categoryRepository.findById(uuid).orElseThrow(() -> new NoResultException("Categoria não encontrada."));
    }

    public CategoryModel save(CategoryModel categoryModel) {
        if (categoryRepository.existsByCategoryName(categoryModel.getCategoryName())) {
            throw new DataAlreadyRegisteredException("Categoria informada já existe no sistema.");
        }

        return categoryRepository.save(categoryModel);
    }

    public CategoryModel update(CategoryModel categoryModel, UUID uuid) {
        categoryRepository.findById(uuid).orElseThrow(() -> new NoResultException("Categoria não encontrada."));
        categoryModel.setCategoryId(uuid);
        categoryRepository.save(categoryModel);
        return categoryModel;
    }

    public UUID delete(UUID uuid) {
        var categoryModel = categoryRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException("Categoria não encontrada."));
        categoryRepository.delete(categoryModel);
        return uuid;
    }
}
