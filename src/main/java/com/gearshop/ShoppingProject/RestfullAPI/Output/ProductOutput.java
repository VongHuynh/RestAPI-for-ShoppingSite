package com.gearshop.ShoppingProject.RestfullAPI.Output;

import com.gearshop.ShoppingProject.DTO.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOutput {
    private int page;
    private int totalPages;
    private List<ProductDTO> listResults = new ArrayList<>();
}
