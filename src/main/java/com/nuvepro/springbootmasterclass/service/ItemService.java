package com.nuvepro.springbootmasterclass.service;

import com.nuvepro.springbootmasterclass.entity.ItemEntity;

import java.util.List;

public interface ItemService {

    ItemEntity createItem(ItemEntity itemEntity);

    List<ItemEntity> getAllItem();

    ItemEntity getItemById(Integer id);
}