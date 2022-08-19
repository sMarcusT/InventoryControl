package com.inventorycontrol.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "provider", schema = "inventory")
public class ProviderModel {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID providerId;

    private String providerName;

    private String address;

    private String num;

    private String district;

    private String cep;

    private String contact;

    private String cnpj;

    private String insc;

    private String telephone;
}
