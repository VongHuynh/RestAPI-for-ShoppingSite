package com.gearshop.ShoppingProject.Service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gearshop.ShoppingProject.DTO.OrderDTO;
import com.gearshop.ShoppingProject.Entity.OrderDetail;
import com.gearshop.ShoppingProject.Entity.Orders;
import com.gearshop.ShoppingProject.Repository.OrderDetailRepository;
import com.gearshop.ShoppingProject.Repository.OrderRepository;
import com.gearshop.ShoppingProject.Service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            orderRepository.deleteById(id);
        }
    }

    @Override
    public List<OrderDTO> findAll(Pageable pageable) {
        List<OrderDTO> listProductDTO = new ArrayList<>();
        List<Orders> listOder = orderRepository.findAll(pageable).getContent();
        for (Orders item : listOder) {
            OrderDTO orderDTO = modelMapper.map(item, OrderDTO.class);
            listProductDTO.add(orderDTO);
        }
        return listProductDTO;
    }

    @Override
    public List<OrderDTO> findAll() {
        List<Orders> listOrder = orderRepository.findAll();
        List<OrderDTO> listOrderDTO = modelMapper.map(listOrder, new TypeToken<List<OrderDTO>>() {
        }.getType());
        return listOrderDTO;
    }

    @Override
    public OrderDTO findById(Integer id) {
        Optional<Orders> order = orderRepository.findById(id);
        return modelMapper.map(order.get(), OrderDTO.class);
    }

    @Override
    public List<OrderDTO> findByUsername(String username) {
        List<Orders> ListOrder = orderRepository.findByUsername(username);
        List<OrderDTO> listOrderDTO = modelMapper.map(ListOrder, new TypeToken<List<OrderDTO>>() {
        }.getType());
        return listOrderDTO;
    }

    @Override
    public int totalItem() {
        return (int) orderRepository.count();
    }

    public Orders create(JsonNode orderData) {
        ObjectMapper mapper = new ObjectMapper();
        Orders order = mapper.convertValue(orderData, Orders.class);
        orderRepository.save(order);
        TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
        List<OrderDetail> details = mapper.convertValue(orderData.get("orderdetail"), type)
                .stream().peek(d -> d.setOrders(order)).collect(Collectors.toList());
        orderDetailRepository.saveAll(details);
        return order;
    }
}
