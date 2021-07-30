package com.nuvepro.springbootmasterclass.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JoinColumn
    @ManyToOne
    private ItemEntity itemEntity;

    @Column
    private Integer quantity;

    @Column
    private OrderStatus status;

}