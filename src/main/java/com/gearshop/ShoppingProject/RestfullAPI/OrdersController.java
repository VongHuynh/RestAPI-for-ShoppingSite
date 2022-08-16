package com.gearshop.ShoppingProject.RestfullAPI;

import com.fasterxml.jackson.databind.JsonNode;
import com.gearshop.ShoppingProject.RestfullAPI.Output.OrdersOutput;
import com.gearshop.ShoppingProject.DTO.OrderDTO;
import com.gearshop.ShoppingProject.Entity.Orders;
import com.gearshop.ShoppingProject.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("Orders")
public class OrdersController {
    @Autowired
    OrderService orderService;

    @GetMapping
    public OrdersOutput showOderPegeable(@RequestParam("page")int page,
                                             @RequestParam("limit")int limit){
        OrdersOutput ordersOutput = new OrdersOutput();
        ordersOutput.setPage(page);
        ordersOutput.setTotalPages((int) Math.ceil((double) (orderService.totalItem()/limit)));
        List<OrderDTO> list = orderService.findAll(PageRequest.of(page-1, limit));
        ordersOutput.setListResults(list);
        return ordersOutput;
    }

    @GetMapping("/{id}")
    public OrderDTO showOrderByID(@PathVariable("id") Integer id){
        return orderService.findById(id);
    }

    @GetMapping("/{username}")
    public List<OrderDTO> showOrderByUsername(@PathVariable("username") String username){
        return orderService.findByUsername(username);
    }

    @GetMapping("all")
    public List<OrderDTO> showAllOrders(){
        return orderService.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping()
    public void deleteOrder(@PathVariable("id") Integer[] id){
        orderService.delete(id);
    }

    @PostMapping()
    public Orders purchase(@RequestBody JsonNode orderData) {
        return orderService.create(orderData);
    }
}
