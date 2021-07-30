package com.nuvepro.springbootmasterclass.service;

import com.nuvepro.springbootmasterclass.OrderRequest;
import com.nuvepro.springbootmasterclass.entity.ItemEntity;
import com.nuvepro.springbootmasterclass.entity.OrderEntity;
import com.nuvepro.springbootmasterclass.entity.OrderStatus;
import com.nuvepro.springbootmasterclass.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemService itemService;

   @Override
   public OrderEntity createOrder(OrderRequest orderRequest) {

       ItemEntity itemEntity = itemService.getItemById(orderRequest.getItemId());

       if (itemEntity==null)
           return null;

       OrderEntity orderEntity = new OrderEntity();
       orderEntity.setStatus(OrderStatus.ORDER_PLACED);
       orderEntity.setItemEntity(itemEntity);
       orderEntity.setQuantity(orderRequest.getQuantity());

       orderRepository.save(orderEntity);

       return orderEntity;
   }

    @Override
    public List<OrderEntity> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public OrderEntity getOrderById(Integer id) {

        //fetch order using id
        Optional<OrderEntity> orderEntity = orderRepository.findById(id);

        if (!orderEntity.isPresent()) {
            return null;
        }
        
        return orderEntity.get();
    }

    @Override
    public void updateOrderStatus(Integer orderId, OrderStatus status) {
        OrderEntity orderEntity = orderRepository.getById(orderId);
        orderEntity.setStatus(status);
        orderRepository.save(orderEntity);
    }


}


