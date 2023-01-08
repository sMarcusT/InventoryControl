package com.inventorycontrol.http.mapper;

import com.inventorycontrol.http.dto.request.ShippingCompanyRequest;
import com.inventorycontrol.http.dto.response.CategoryResponse;
import com.inventorycontrol.http.dto.response.ShippingCompanyResponse;
import com.inventorycontrol.model.CategoryModel;
import com.inventorycontrol.model.ShippingCompanyModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ShippingCompanyMapper {

    public static ShippingCompanyModel toModel(ShippingCompanyRequest request) {
        return ShippingCompanyModel.builder()
                .name(request.getName())
                .address(request.getAddress())
                .number(request.getNumber())
                .district(request.getDistrict())
                .zipCode(request.getZipCode())
                .cnpj(request.getCnpj())
                .subscription(request.getSubscription())
                .contact(request.getContact())
                .telephone(request.getTelephone())
                .build();
    }

    public static ShippingCompanyResponse toResponse(ShippingCompanyModel model) {
        return ShippingCompanyResponse.builder()
                .shippingCompanyId(model.getShippingCompanyId())
                .name(model.getName())
                .address(model.getAddress())
                .number(model.getNumber())
                .district(model.getDistrict())
                .zipCode(model.getZipCode())
                .cnpj(model.getCnpj())
                .subscription(model.getSubscription())
                .contact(model.getContact())
                .telephone(model.getTelephone())
                .build();
    }

    public static List<ShippingCompanyResponse> toResponseList(List<ShippingCompanyModel> shippingCompanyModels) {
        if (Objects.isNull(shippingCompanyModels)) {
            return new ArrayList<>();
        } else {
            return shippingCompanyModels.stream().map(ShippingCompanyMapper::toResponse).collect(Collectors.toList());
        }
    }
}
