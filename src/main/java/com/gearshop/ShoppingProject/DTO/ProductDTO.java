package com.gearshop.ShoppingProject.DTO;

import com.gearshop.ShoppingProject.Entity.Category;
import lombok.Data;

import java.util.Date;
@Data
public class ProductDTO extends AbstractDTO{
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private Date createDate = new Date();
    private Boolean available;
    private Category category;
}
