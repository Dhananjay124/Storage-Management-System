package com.wms.Storage.Management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wms.Storage.Management.dto.InventoryDTO;
import com.wms.Storage.Management.entity.Inventory;
import com.wms.Storage.Management.service.InventoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
	
	@Autowired
    private InventoryService service;

    @PostMapping("/add")
    public Inventory createInventory(@Valid @RequestBody InventoryDTO dto) {
        return service.createInventory(dto);
    }

    @GetMapping
    public List<Inventory> getAllInventory() {
        return service.getAllInventory();
    }

    @GetMapping("/{id}")
    public Inventory getInventory(@PathVariable Long id) {
        return service.getInventoryById(id);
    }

    @PutMapping("/{id}")
    public Inventory updateInventory(@PathVariable Long id,
                                     @RequestBody InventoryDTO dto) {

        return service.updateInventory(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteInventory(@PathVariable Long id) {

        service.deleteInventory(id);
        return "Inventory deleted successfully";
    }

}
