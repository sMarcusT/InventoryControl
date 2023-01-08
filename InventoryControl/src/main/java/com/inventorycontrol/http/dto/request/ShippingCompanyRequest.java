package com.inventorycontrol.http.dto.request;

import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ShippingCompanyRequest {

    @NotBlank(message = "Informe o nome da transportadora.")
    private String name;

    @NotBlank(message = "Informe o endereço.")
    private String address;

    @NotNull(message = "Informe o número.")
    private Integer number;

    @NotBlank(message = "Informe o bairro.")
    private String district;

    @NotBlank(message = "Informe o CEP.")
    private String zipCode;

    @NotBlank(message = "Informe o CNPJ.")
    @CNPJ
    private String cnpj;

    @NotBlank(message = "Informe a inscrição.")
    private String subscription;

    @NotBlank(message = "Informe o contato.")
    private String contact;

    @NotBlank(message = "Informe o telefone para contato.")
    private String telephone;
}
