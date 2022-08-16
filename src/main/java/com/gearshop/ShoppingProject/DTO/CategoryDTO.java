package com.gearshop.ShoppingProject.DTO;

import lombok.Data;

@Data
public class CategoryDTO extends AbstractDTO<CategoryDTO>{
    private Integer id;
    private String name;
}
