package com.inventorycontrol.http.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Getter
@Setter
public class ProductRequest {

    @NotEmpty(message = "Informe o nome do produto.")
    private String productName;

    @NotEmpty(message = "Informe o peso.")
    private String weight;

    private boolean controlled;

    @NotBlank(message = "Informe a quantidade mínima.")
    private Integer minimumQuantity;

    private UUID categoryId;
}
