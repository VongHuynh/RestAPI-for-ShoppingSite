package com.gearshop.ShoppingProject.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.gearshop.ShoppingProject.DTO.OrderDTO;
import com.gearshop.ShoppingProject.Entity.Orders;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    Orders create(JsonNode orderData) ;
    OrderDTO findById(Integer id) ;
    List<OrderDTO> findByUsername(String username) ;
    List<OrderDTO> findAll(Pageable pageable);
    List<OrderDTO> findAll();
    void delete(Integer[] ids);
    int totalItem();
}
