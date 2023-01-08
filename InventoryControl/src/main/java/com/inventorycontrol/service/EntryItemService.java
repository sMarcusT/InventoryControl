package com.inventorycontrol.service;

import com.inventorycontrol.model.EntryItemModel;
import com.inventorycontrol.repository.EntryItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class EntryItemService {

    private final EntryItemRepository itemRepository;

    public List<EntryItemModel> findAll() {
        return itemRepository.findAll();
    }

    public EntryItemModel findById(UUID uuid) {
        return itemRepository.findById(uuid).orElseThrow(() -> new NoResultException("Item de entrada não encontrado."));
    }

    public EntryItemModel save(EntryItemModel entryItemModel) {
        return itemRepository.save(entryItemModel);
    }

    public EntryItemModel update(UUID uuid, EntryItemModel entryItemModel) {
        itemRepository.findById(uuid).orElseThrow(() -> new NoResultException("Item de entrada não encontrado."));
        entryItemModel.setEntryItemId(uuid);
        itemRepository.save(entryItemModel);
        return entryItemModel;
    }

    public UUID delete(UUID uuid) {
        var response = itemRepository.findById(uuid).orElseThrow(() -> new NoResultException("Item de entrada não encontrado."));
        itemRepository.delete(response);
        return uuid;
    }
}
