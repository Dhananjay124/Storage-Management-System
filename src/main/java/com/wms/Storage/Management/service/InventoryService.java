package com.wms.Storage.Management.service;

import java.util.List;

import com.wms.Storage.Management.dto.InventoryDTO;
import com.wms.Storage.Management.entity.Inventory;

public interface InventoryService {

	  Inventory createInventory(InventoryDTO dto);

	    List<Inventory> getAllInventory();

	    Inventory getInventoryById(Long id);

	    Inventory updateInventory(Long id, InventoryDTO dto);

	    void deleteInventory(Long id);
	
}
