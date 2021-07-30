package com.nuvepro.springbootmasterclass.controller;

import com.nuvepro.springbootmasterclass.OrderRequest;
import com.nuvepro.springbootmasterclass.entity.OrderEntity;
import com.nuvepro.springbootmasterclass.entity.OrderStatus;
import com.nuvepro.springbootmasterclass.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequest orderRequest) {
        try {
            OrderEntity order = orderService.createOrder(orderRequest);
            if (order == null)
                return new ResponseEntity<>("Unable to place the order", HttpStatus.BAD_REQUEST);
            else
                return new ResponseEntity<>("Order placed", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unable to place the order", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public List<OrderEntity> getAllOder() {
        try {
            return orderService.getAllOrder();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/{orderId}")
    public OrderEntity getOrderById(@PathVariable Integer orderId) {
        try {
            return orderService.getOrderById(orderId);
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/{orderId}/{status}")
    public String updateOrderStatus(@PathVariable Integer orderId, @PathVariable OrderStatus status) {
        try {
            orderService.updateOrderStatus(orderId, status);
            return "Order status changed";
        } catch (Exception e) {
            return null;
        }
    }

}