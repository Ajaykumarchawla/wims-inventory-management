package com.ajayk.wims.item;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<List<ItemResponseDto>> getItem() {
        return ResponseEntity.ok(itemService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ItemResponseDto> getItemById(@PathVariable Long id) {
        return new ResponseEntity<>(itemService.getById(id),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ItemResponseDto> createItem(@RequestBody ItemRequestDto requestDto) {
        return new ResponseEntity<>(itemService.createItem(requestDto), HttpStatus.CREATED);
    }



    @PutMapping("/{id}")
    public ResponseEntity<ItemResponseDto> updateItem(@PathVariable Long id,@RequestBody ItemRequestDto requestDto) {
        return ResponseEntity.ok(itemService.updateItem(id,requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ItemResponseDto> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
