package com.inventorycontrol.service;

import com.inventorycontrol.exception.DataAlreadyRegisteredException;
import com.inventorycontrol.model.ProductModel;
import com.inventorycontrol.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    public ProductModel findById(UUID uuid) {
        return productRepository.findById(uuid).orElseThrow(() -> new NoResultException("Produto não encontrado."));
    }

    public ProductModel save(ProductModel productModel) {
        if (productRepository.existsByProductName(productModel.getProductName())) {
            throw new DataAlreadyRegisteredException("Produto informado já existe no sistema.");
        }

        return productRepository.save(productModel);
    }

    public ProductModel update(ProductModel productModel, UUID uuid) {
        productRepository.findById(uuid).orElseThrow(() -> new NoResultException("Produto não encontrado."));
        productModel.setProductId(uuid);
        productRepository.save(productModel);
        return productModel;
    }

    public UUID delete(UUID uuid) {
        var productModel = productRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException("Produto não encontrado."));
        productRepository.delete(productModel);
        return uuid;
    }
}
