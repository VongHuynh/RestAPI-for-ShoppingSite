package com.gearshop.ShoppingProject.Service.impl;

import com.gearshop.ShoppingProject.DTO.OrderDetailDTO;
import com.gearshop.ShoppingProject.Entity.OrderDetail;
import com.gearshop.ShoppingProject.Repository.OrderDetailRepository;
import com.gearshop.ShoppingProject.Service.OrderDetailService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public OrderDetailDTO save(OrderDetailDTO OrderDetailDTO) {
        OrderDetail newOrderDetail = new OrderDetail();
        newOrderDetail = modelMapper.map(OrderDetailDTO, OrderDetail.class);
        newOrderDetail = orderDetailRepository.save(newOrderDetail);
        return modelMapper.map(newOrderDetail, OrderDetailDTO.class);
    }

    @Override
    public void delete(Integer[] ids) {
        for(Integer id : ids){
            orderDetailRepository.deleteById(id);
        }
    }

    @Override
    public List<OrderDetailDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<OrderDetailDTO> findAll() {
        List<OrderDetail> listOrderDetail = orderDetailRepository.findAll();
        List<OrderDetailDTO> listOrderDetailDTO = modelMapper.map(listOrderDetail, new TypeToken<List<OrderDetailDTO>>(){}.getType());
        return listOrderDetailDTO;
    }

    @Override
    public OrderDetailDTO findById(Integer id) {
        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(id);
        return modelMapper.map(orderDetail.get(), OrderDetailDTO.class);
    }

    @Override
    public int totalItem() {
        return (int) orderDetailRepository.count();
    }
}
