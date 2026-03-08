package com.wms.Storage.Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.Storage.Management.Repository.InventoryRepository;
import com.wms.Storage.Management.dto.InventoryDTO;
import com.wms.Storage.Management.entity.Inventory;

@Service
public class InventoryServiceImpl  implements InventoryService{


    @Autowired
    private InventoryRepository repository;

    @Override
    public Inventory createInventory(InventoryDTO dto) {

        Inventory inventory = new Inventory();
        inventory.setProductName(dto.getProductName());
        inventory.setQuantity(dto.getQuantity());
        inventory.setLocation(dto.getLocation());

        return repository.save(inventory);
    }

    @Override
    public List<Inventory> getAllInventory() {
        return repository.findAll();
    }

    @Override
    public Inventory getInventoryById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));
    }

    @Override
    public Inventory updateInventory(Long id, InventoryDTO dto) {

        Inventory inventory = getInventoryById(id);

        inventory.setProductName(dto.getProductName());
        inventory.setQuantity(dto.getQuantity());
        inventory.setLocation(dto.getLocation());

        return repository.save(inventory);
    }

    @Override
    public void deleteInventory(Long id) {
        repository.deleteById(id);
    }
}
