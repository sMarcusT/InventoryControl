package com.inventorycontrol.http.dto.request;

import lombok.Data;

@Data
public class ExitRequest {

    private Double total;

    private Double shipping;

    private Double tax;
}
