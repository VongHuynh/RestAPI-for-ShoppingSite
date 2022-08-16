package com.gearshop.ShoppingProject.RestfullAPI;

import com.gearshop.ShoppingProject.DTO.CategoryDTO;
import com.gearshop.ShoppingProject.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("all")
    public List<CategoryDTO> showAllCategories(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDTO showCategoryByID(@PathVariable("id") Integer id){
        return categoryService.findById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryService.save(categoryDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public CategoryDTO updateProduct(@RequestBody CategoryDTO categoryDTO, @PathVariable("id") Integer id){
        categoryDTO.setId(id);
        return categoryService.save(categoryDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping
    public void deleteCategory(@PathVariable("id") Integer[] id){
        categoryService.delete(id);
    }
}
