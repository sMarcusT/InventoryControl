package com.inventorycontrol.http.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ProviderRequest {

    @NotEmpty(message = "Informe o nome do fornecedor.")
    private String providerName;

    @NotEmpty(message = "Informe o endereço.")
    private String address;

    @NotEmpty(message = "Informe o número.")
    private String num;

    @NotEmpty(message = "Informe o bairro.")
    private String district;

    @NotEmpty(message = "Informe o CEP.")
    private String cep;

    @NotEmpty(message = "Informe o contato.")
    private String contact;

    @NotEmpty(message = "Informe o CNPJ.")
    @CNPJ
    private String cnpj;

    @NotEmpty(message = "informe o número de inscrição.")
    private String insc;

    @NotEmpty(message = "Informe o telefone.")
    @Size(max = 14, min = 11)
    private String telephone;

    private List<UUID> cityListIds;
}
