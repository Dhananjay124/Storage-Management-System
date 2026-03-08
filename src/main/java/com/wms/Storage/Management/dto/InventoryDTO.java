package com.wms.Storage.Management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDTO {

	  @NotBlank
	    private String productName;

	    @Positive
	    private int quantity;

	    @NotBlank
	    private String location;
}
