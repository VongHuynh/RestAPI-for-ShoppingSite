package com.gearshop.ShoppingProject.RestfullAPI;

import com.gearshop.ShoppingProject.RestfullAPI.Output.ProductOutput;
import com.gearshop.ShoppingProject.DTO.ProductDTO;
import com.gearshop.ShoppingProject.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping()
    public ProductOutput showProductPegeable(@RequestParam("page")int page,
                                     @RequestParam("limit")int limit){
        ProductOutput productOutput = new ProductOutput();
            productOutput.setPage(page);
            productOutput.setTotalPages((int) Math.ceil((double) (productService.totalItem()/limit)));
            List<ProductDTO> list = productService.findAll(PageRequest.of(page-1, limit));
            productOutput.setListResults(list);
            return productOutput;
    }

    @GetMapping("/{id}")
    public ProductDTO showProductByID(@PathVariable("id") Integer id){
        return productService.findById(id);
    }

    @GetMapping("all")
    public List<ProductDTO> showAllProduct(){
        return productService.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO){
        return productService.save(productDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO, @PathVariable("id") Integer id){
        productDTO.setId(id);
            return productService.save(productDTO);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping
    public void deleteProduct(@PathVariable("id") Integer[] id){
        productService.delete(id);
    }
}
