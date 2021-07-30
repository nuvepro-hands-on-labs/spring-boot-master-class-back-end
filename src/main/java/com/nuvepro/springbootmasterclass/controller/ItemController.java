package com.nuvepro.springbootmasterclass.controller;

import com.nuvepro.springbootmasterclass.entity.ItemEntity;
import com.nuvepro.springbootmasterclass.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<?> createItem(@RequestBody ItemEntity itemEntity) {
        try {
            return buildSuccessResponse(itemService.createItem(itemEntity));
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping
    public List<ItemEntity> getAllItem() {
        try {
            return itemService.getAllItem();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/{id}")
    public ItemEntity getItemById(@PathVariable Integer id) {
        try {
            return itemService.getItemById(id);
        } catch (Exception e) {
            return null;
        }
    }

    private ResponseEntity<?> buildSuccessResponse(Object object) {
        return new ResponseEntity<>(object, HttpStatus.OK);
    }
}