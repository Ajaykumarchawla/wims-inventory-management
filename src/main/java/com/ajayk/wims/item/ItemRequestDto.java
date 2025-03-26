package com.ajayk.wims.item;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class ItemRequestDto {
    @NotBlank(message = "Name cannot be blank")
    private String itemName;
    private String itemDescription;

    private String itemCategory;

    @DecimalMin(value = "0.0", inclusive = true,message = "Price must be positive")
    private BigDecimal itemPrice;

    @NotNull(message = "Quantity cannot be null")
    @Min(value =0, message ="Quantity must be greater than or equal to 0")
    private Integer itemQuantity;

    private String itemLocation;
}
