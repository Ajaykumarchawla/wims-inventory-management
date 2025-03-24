package com.ajayk.wims.item;

import java.util.List;

public interface ItemService {
    List<ItemResponseDto> getAll();
    ItemResponseDto createItem(ItemRequestDto itemRequestDto);
    ItemResponseDto updateItem(Long id, ItemRequestDto itemRequestDto);
    ItemResponseDto getById(Long id);
    void deleteItem(Long id);
}
