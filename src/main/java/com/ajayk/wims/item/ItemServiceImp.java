package com.ajayk.wims.item;

import com.ajayk.wims.util.MapperUtil;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImp implements ItemService{

    private final ItemRepository itemRepository;
    private final MapperUtil mapperUtil;

    @Override
    public List<ItemResponseDto> getAll() {

        return itemRepository.findAll().stream()
                .map(mapperUtil::toItemResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public ItemResponseDto getById(Long id) {
        return mapperUtil.toItemResponseDto(itemRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Item not Found")));
    }

    @Override
    public ItemResponseDto createItem(ItemRequestDto requestDto){
        Item item = mapperUtil.toItem(requestDto);
        itemRepository.save(item);
        return mapperUtil.toItemResponseDto(item);
    }


    @Override
    public ItemResponseDto updateItem(Long id,ItemRequestDto itemRequestDto){

        Item item = itemRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Item not Found"));
        item.setItemName(itemRequestDto.getItemName());
        item.setItemDescription(itemRequestDto.getItemDescription());
        item.setItemCategory(itemRequestDto.getItemCategory());
        item.setItemPrice(itemRequestDto.getItemPrice());
        item.setItemQuantity(itemRequestDto.getItemQuantity());
        item.setItemLocation(itemRequestDto.getItemLocation());

        itemRepository.save(item);
        return mapperUtil.toItemResponseDto(item);
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }


}
