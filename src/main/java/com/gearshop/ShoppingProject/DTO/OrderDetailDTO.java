package com.gearshop.ShoppingProject.DTO;

import com.gearshop.ShoppingProject.Entity.Orders;
import com.gearshop.ShoppingProject.Entity.Product;
import lombok.Data;

@Data
public class OrderDetailDTO extends AbstractDTO<OrderDetailDTO>{
    private Integer id;
    private Double price;
    private Integer quantity;
    private Product product;
    private Orders orders;
}
