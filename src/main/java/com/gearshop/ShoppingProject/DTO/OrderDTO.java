package com.gearshop.ShoppingProject.DTO;

import com.gearshop.ShoppingProject.Entity.Account;
import com.gearshop.ShoppingProject.Entity.OrderDetail;
import com.gearshop.ShoppingProject.Entity.Orders;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO extends AbstractDTO<Orders>{
    private Integer id;
    private String address;
    private Integer status;
    private Account account;
}
