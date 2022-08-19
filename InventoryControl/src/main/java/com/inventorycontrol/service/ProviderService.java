package com.inventorycontrol.service;

import com.inventorycontrol.exception.DataAlreadyRegisteredException;
import com.inventorycontrol.model.ProviderModel;
import com.inventorycontrol.repository.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProviderService {

    private final ProviderRepository providerRepository;

    public List<ProviderModel> findAll() {
        return providerRepository.findAll();
    }

    public ProviderModel findById(UUID uuid) {
        return providerRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException("Fornecedor não encontrado."));
    }

    public ProviderModel save(ProviderModel providerModel) {
        if (providerRepository.existsByProviderName(providerModel.getProviderName())) {
            throw new DataAlreadyRegisteredException("Já existe um fornecedor com esse nome.");
        } else {
            return providerRepository.save(providerModel);
        }
    }

    public ProviderModel update(ProviderModel providerModel, UUID uuid) {
        providerRepository.findById(uuid).orElseThrow(() -> new NoResultException("Fornecedor não encontrado."));
        providerModel.setProviderId(uuid);
        providerRepository.save(providerModel);
        return providerModel;
    }

    public UUID delete(UUID uuid) {
        var providerModel = providerRepository.findById(uuid)
                .orElseThrow(() -> new NoResultException("Fornecedor não encontrado."));
        providerRepository.delete(providerModel);
        return uuid;
    }
}
