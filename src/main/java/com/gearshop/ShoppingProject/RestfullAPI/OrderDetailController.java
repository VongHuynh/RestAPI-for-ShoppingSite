package com.gearshop.ShoppingProject.RestfullAPI;

import com.gearshop.ShoppingProject.DTO.OrderDetailDTO;
import com.gearshop.ShoppingProject.Service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("OrderDetails")
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;

    @GetMapping("/{id}")
    public OrderDetailDTO showOrderDetailByID(@PathVariable("id") Integer id){
        return orderDetailService.findById(id);
    }

    @GetMapping("all")
    public List<OrderDetailDTO> showAllOrderDetail(){
        return orderDetailService.findAll();
    }

    @PostMapping()
    public OrderDetailDTO createOrderDetail(@RequestBody OrderDetailDTO orderDetailDTO){
        return orderDetailService.save(orderDetailDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping
    public void deleteOrderDetail(@PathVariable("id") Integer[] id){
        orderDetailService.delete(id);
    }
}
