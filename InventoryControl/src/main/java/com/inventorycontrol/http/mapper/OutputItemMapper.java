package com.inventorycontrol.http.mapper;

import com.inventorycontrol.http.dto.request.CategoryRequest;
import com.inventorycontrol.http.dto.request.OutputItemRequest;
import com.inventorycontrol.http.dto.response.CategoryResponse;
import com.inventorycontrol.http.dto.response.OutputItemResponse;
import com.inventorycontrol.model.CategoryModel;
import com.inventorycontrol.model.OutputItemModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class OutputItemMapper {

    public static OutputItemModel toModel(OutputItemRequest request) {
        return OutputItemModel.builder()
                .batch(request.getBatch())
                .amount(request.getAmount())
                .value(request.getValue())
                .build();
    }

    public static OutputItemResponse toResponse(OutputItemModel outputItemModel) {
        return OutputItemResponse.builder()
                .outputItemId(outputItemModel.getOutputItemId())
                .batch(outputItemModel.getBatch())
                .batch(outputItemModel.getBatch())
                .amount(outputItemModel.getAmount())
                .value(outputItemModel.getValue())
                .build();
    }

    public static List<OutputItemResponse> toResponseList(List<OutputItemModel> outputItemModels) {
        if (Objects.isNull(outputItemModels)) {
            return new ArrayList<>();
        } else {
            return outputItemModels.stream().map(OutputItemMapper::toResponse).collect(Collectors.toList());
        }
    }
}