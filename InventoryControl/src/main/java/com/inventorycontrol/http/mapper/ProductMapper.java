package com.inventorycontrol.http.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.inventorycontrol.http.dto.request.ProductRequest;
import com.inventorycontrol.http.dto.response.ProductResponse;
import com.inventorycontrol.model.CategoryModel;
import com.inventorycontrol.model.ProductModel;

@Component
public class ProductMapper {

    public static ProductModel toModel(ProductRequest productRequest) {
        return ProductModel.builder()
                .productName(productRequest.getProductName())
                .weight(productRequest.getWeight())
                .controlled(productRequest.isControlled())
                .minimumQuantity(productRequest.getMinimumQuantity())
                .categoryModel(CategoryModel.builder().categoryId(productRequest.getCategoryId()).build())
                .build();
    }

    public static ProductResponse toResponse(ProductModel productModel) {
        return ProductResponse.builder()
                .productId(productModel.getProductId())
                .productName(productModel.getProductName())
                .weight(productModel.getWeight())
                .controlled(productModel.isControlled())
                .minimumQuantity(productModel.getMinimumQuantity())
                .build();
    }

    public static List<ProductResponse> toResponseList(List<ProductModel> productModelList) {
        if (Objects.isNull(productModelList)) {
            return new ArrayList<>();
        } else {
            return productModelList.stream().map(ProductMapper::toResponse).collect(Collectors.toList());
        }
    }
}
