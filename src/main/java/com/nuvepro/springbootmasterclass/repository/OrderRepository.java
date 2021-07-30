package com.nuvepro.springbootmasterclass.repository;

import com.nuvepro.springbootmasterclass.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}