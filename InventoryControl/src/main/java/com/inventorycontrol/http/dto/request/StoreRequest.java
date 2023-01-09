package com.inventorycontrol.http.dto.request;

import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
public class StoreRequest {

    private String name;

    private String zipCode;

    private String address;

    private Integer number;

    private String district;

    private String telephone;

    private String subscription;

    @CNPJ
    private String cnpj;
}
