package com.ajayk.wims.item;

import lombok.Data;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.time.LocalDateTime;

@Data
public class ItemResponseDto {
    private Long id;
    private String itemName;
    private String itemDescription;
    private String itemCategory;
    private BigDecimal itemPrice;
    private String itemQuantity;
    private String itemLocation;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
