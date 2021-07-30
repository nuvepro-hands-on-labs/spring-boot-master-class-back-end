package com.nuvepro.springbootmasterclass;

import lombok.Data;

@Data
public class OrderRequest {
    private Integer itemId;
    private Integer quantity;
}
