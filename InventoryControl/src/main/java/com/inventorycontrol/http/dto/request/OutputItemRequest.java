package com.inventorycontrol.http.dto.request;

import lombok.Data;

@Data
public class OutputItemRequest {

    private String batch;

    private Integer amount;

    private Double value;
}
