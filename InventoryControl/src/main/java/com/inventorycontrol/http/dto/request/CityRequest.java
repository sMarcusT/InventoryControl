package com.inventorycontrol.http.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CityRequest {

    @NotEmpty(message = "Informe o nome da cidade.")
    private String cityName;

    @NotEmpty(message = "Informe a unidade federativa da cidade.")
    private String uf;
}
