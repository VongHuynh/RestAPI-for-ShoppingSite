package com.gearshop.ShoppingProject.Service;

import com.gearshop.ShoppingProject.DTO.ProductDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductDTO save(ProductDTO obj);
    void delete(Integer[] ids);
    List<ProductDTO> findAll(Pageable pageable);
    List<ProductDTO> findAll();
    ProductDTO findById(Integer id);
    int totalItem();
}
