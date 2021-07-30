package com.nuvepro.springbootmasterclass.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private Integer quantity;

    @Column
    private Boolean isActive;
}
