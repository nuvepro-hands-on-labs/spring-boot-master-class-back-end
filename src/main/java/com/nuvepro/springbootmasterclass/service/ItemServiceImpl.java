package com.nuvepro.springbootmasterclass.service;

import com.nuvepro.springbootmasterclass.entity.ItemEntity;
import com.nuvepro.springbootmasterclass.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public ItemEntity createItem(ItemEntity itemEntity) {
        return itemRepository.save(itemEntity);
    }

    @Override
    public List<ItemEntity> getAllItem() {
        return itemRepository.findAll();
    }

    @Override
    public ItemEntity getItemById(Integer id) {
        Optional<ItemEntity> optionalItemEntity = itemRepository.findById(id);

        return optionalItemEntity.orElse(null);
    }
}