package com.gearshop.ShoppingProject.Service;

import com.gearshop.ShoppingProject.DTO.CategoryDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    CategoryDTO save(CategoryDTO categoryDTO);
    void delete(Integer[] ids);
    List<CategoryDTO> findAll(Pageable pageable);
    List<CategoryDTO> findAll();
    CategoryDTO findById(Integer id);
    int totalItem();
}
