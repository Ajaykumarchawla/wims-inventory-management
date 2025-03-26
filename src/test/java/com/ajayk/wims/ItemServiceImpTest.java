package com.ajayk.wims;

import com.ajayk.wims.exception.ItemNotFoundException;
import com.ajayk.wims.item.*;
import com.ajayk.wims.util.MapperUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ItemServiceImpTest {

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private MapperUtil mapperUtil;

    @InjectMocks
    private ItemServiceImp itemServiceImp;

    private Item item;
    private ItemRequestDto itemRequestDto;
    private ItemResponseDto itemResponseDto;

    @BeforeEach
    void setUp() {

        item = new Item(1L, "Item1", "Description1", "Cat1", BigDecimal.valueOf(10), 10, "Loc1", LocalDateTime.now(), LocalDateTime.now());

        itemRequestDto = new ItemRequestDto();
        itemRequestDto.setItemName("Item1");
        itemRequestDto.setItemDescription("Description1");
        itemRequestDto.setItemCategory("Cat1");
        itemRequestDto.setItemPrice(BigDecimal.valueOf(10));
        itemRequestDto.setItemQuantity(10);
        itemRequestDto.setItemLocation("Loc1");


        itemResponseDto = new ItemResponseDto();
        itemResponseDto.setId(1L);
        itemResponseDto.setItemName("Item1");
        itemResponseDto.setItemDescription("Description1");
        itemResponseDto.setItemCategory("Cat1");
        itemResponseDto.setItemPrice(BigDecimal.valueOf(10));
        itemResponseDto.setItemQuantity(10);
        itemResponseDto.setItemLocation("Loc1");


    }

    @Test
    void createItem_Success(){
        // Arrange
        when(mapperUtil.toItem(itemRequestDto)).thenReturn(item);
        when(itemRepository.save(any(Item.class))).thenReturn(item);
        when(mapperUtil.toItemResponseDto(item)).thenReturn(itemResponseDto);

        // act
        ItemResponseDto result = itemServiceImp.createItem(itemRequestDto);

        // Assert
        assertNotNull(result);
        assertEquals("Item1",result.getItemName());
        verify(itemRepository,times(1)).save(item);

    }

    @Test
    void getById_WhenNotFound_shouldThrowException(){
        // Arrange
        when(itemRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ItemNotFoundException.class, ()->
            itemServiceImp.getById(1L)
        );
        verify(itemRepository,times(1)).findById(1L);

    }
}
