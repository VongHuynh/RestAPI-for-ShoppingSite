package com.gearshop.ShoppingProject.Service.impl;

import com.gearshop.ShoppingProject.DTO.CategoryDTO;
import com.gearshop.ShoppingProject.Entity.Category;
import com.gearshop.ShoppingProject.Repository.CategoryRepository;
import com.gearshop.ShoppingProject.Service.CategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categottyRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category newCategory = new Category();
        if(categoryDTO.getId() != null){
            Optional<Category> oldCategory = categottyRepository.findById(categoryDTO.getId());
            newCategory = modelMapper.map(categoryDTO,oldCategory.get().getClass());
        }else {
            newCategory = modelMapper.map(categoryDTO, Category.class);
        }
        newCategory = categottyRepository.save(newCategory);
        return modelMapper.map(newCategory, CategoryDTO.class);
    }

    @Override
    public void delete(Integer[] ids) {
        for(Integer id : ids){
            categottyRepository.deleteById(id);
        }
    }

    @Override
    public List<CategoryDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<CategoryDTO> findAll() {
        List<Category> listCategories = categottyRepository.findAll();
        List<CategoryDTO> listCategoryDTO = modelMapper.map(listCategories, new TypeToken<List<CategoryDTO>>(){}.getType());
        return listCategoryDTO;
    }

    @Override
    public CategoryDTO findById(Integer id) {
        Optional<Category> category = categottyRepository.findById(id);
        return modelMapper.map(category.get(), CategoryDTO.class);
    }

    @Override
    public int totalItem() {
        return (int) categottyRepository.count();
    }
}
