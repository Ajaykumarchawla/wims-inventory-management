package com.ajayk.wims.item;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class ItemRequestDto {
    private String itemName;
    private String itemDescription;
    private String itemCategory;
    private BigDecimal itemPrice;
    private String itemQuantity;
    private String itemLocation;
}
