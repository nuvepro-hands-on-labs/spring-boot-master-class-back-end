package com.nuvepro.springbootmasterclass.service;

import com.nuvepro.springbootmasterclass.OrderRequest;
import com.nuvepro.springbootmasterclass.entity.OrderEntity;
import com.nuvepro.springbootmasterclass.entity.OrderStatus;

import java.util.List;

public interface OrderService {

    OrderEntity createOrder(OrderRequest orderRequest);

    List<OrderEntity> getAllOrder();

    OrderEntity getOrderById(Integer orderId);

    void updateOrderStatus(Integer orderId, OrderStatus status);
}