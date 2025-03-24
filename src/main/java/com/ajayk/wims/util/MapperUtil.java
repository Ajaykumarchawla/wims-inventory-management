package com.ajayk.wims.util;

import com.ajayk.wims.item.Item;
import com.ajayk.wims.item.ItemRequestDto;
import com.ajayk.wims.item.ItemResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MapperUtil {
    public Item toItem(ItemRequestDto itemRequestDto) {
        Item item = new Item();
        item.setItemName(itemRequestDto.getItemName());
        item.setItemDescription(itemRequestDto.getItemDescription());
        item.setItemCategory(itemRequestDto.getItemCategory());
        item.setItemPrice(itemRequestDto.getItemPrice());
        item.setItemQuantity(itemRequestDto.getItemQuantity());
        item.setItemLocation(itemRequestDto.getItemLocation());
        return item;
    }

    public ItemResponseDto toItemResponseDto(Item item) {
        ItemResponseDto itemResponseDto = new ItemResponseDto();
        itemResponseDto.setId(item.getId());
        itemResponseDto.setItemName(item.getItemName());
        itemResponseDto.setItemDescription(item.getItemDescription());
        itemResponseDto.setItemCategory(item.getItemCategory());
        itemResponseDto.setItemPrice(item.getItemPrice());
        itemResponseDto.setItemQuantity(item.getItemQuantity());
        itemResponseDto.setItemLocation(item.getItemLocation());

        itemResponseDto.setCreatedAt(item.getCreatedAt());
        itemResponseDto.setUpdatedAt(item.getUpdatedAt());
        return itemResponseDto;
    }
}
