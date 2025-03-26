package com.ajayk.wims;

import com.ajayk.wims.item.Item;
import com.ajayk.wims.item.ItemRepository;
import com.ajayk.wims.item.ItemRequestDto;
import com.ajayk.wims.util.MapperUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ItemControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Item item;
    @Autowired
    private MapperUtil mapperUtil;

    @BeforeEach
    void setUp(){
        itemRepository.deleteAll();

        item = new Item();
        item.setItemName("Item 1");
        item.setItemDescription("Item Description 1");
        item.setItemCategory("Item Category 1");
        item.setItemPrice(BigDecimal.valueOf(10));
        item.setItemQuantity(5);
        item.setItemLocation("Item Location 1");

        itemRepository.save(item);
    }

    @Test
    void testGetById_Success() throws Exception {
        mockMvc.perform(get("/api/item/{id}",item.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.itemName").value("Item 1"));
    }

    @Test
    void testCreateItem_Success() throws Exception {
        ItemRequestDto requestDto = new ItemRequestDto();
        requestDto.setItemName("Item 2");
        requestDto.setItemDescription("Item Description 1");
        requestDto.setItemCategory("Item Category 1");
        requestDto.setItemPrice(BigDecimal.valueOf(10));
        requestDto.setItemQuantity(5);
        requestDto.setItemLocation("Item Location 1");

        mockMvc.perform(post("/api/item")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.itemName").value("Item 2"));
    }

    @Test
    void testItemDelete_Success() throws Exception {
        mockMvc.perform(delete("/api/item/{id}",item.getId())
                .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isNoContent());
    }
}
