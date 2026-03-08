package com.wms.Storage.Management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

	@NotBlank
    private String productName;

    @Positive
    private int quantity;

    @Positive
    private double price;

    private String status;
}
