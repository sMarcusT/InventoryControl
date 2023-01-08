package com.inventorycontrol.http.dto.request;

import lombok.Data;

@Data
public class EntryItemRequest {

    private String batch;

    private Integer amount;

    private Double value;
}
