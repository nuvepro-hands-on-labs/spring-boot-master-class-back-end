package com.nuvepro.springbootmasterclass.repository;

import com.nuvepro.springbootmasterclass.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
}