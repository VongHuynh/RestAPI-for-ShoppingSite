package com.gearshop.ShoppingProject.Service;

import com.gearshop.ShoppingProject.DTO.OrderDetailDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderDetailService {
    OrderDetailDTO save(OrderDetailDTO obj);
    void delete(Integer[] ids);
    List<OrderDetailDTO> findAll(Pageable pageable);
    List<OrderDetailDTO> findAll();
    OrderDetailDTO findById(Integer id);
    int totalItem();
}
