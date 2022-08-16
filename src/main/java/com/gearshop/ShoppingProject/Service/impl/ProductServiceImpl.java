package com.gearshop.ShoppingProject.Service.impl;


import com.gearshop.ShoppingProject.DTO.ProductDTO;
import com.gearshop.ShoppingProject.Entity.Product;
import com.gearshop.ShoppingProject.Repository.ProductRepository;
import com.gearshop.ShoppingProject.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product newProduct = new Product();
        if(productDTO.getId() != null){
            Optional<Product> oldProduct = productRepository.findById(productDTO.getId());
            newProduct = modelMapper.map(productDTO,oldProduct.get().getClass());
        }else {
            newProduct = modelMapper.map(productDTO, Product.class);
        }
        newProduct = productRepository.save(newProduct);
        return modelMapper.map(newProduct, ProductDTO.class);
    }

    @Override
    public void delete(Integer[] ids) {
        for(Integer id : ids){
            productRepository.deleteById(id);
        }
    }

    @Override
    public List<ProductDTO> findAll(Pageable pageable) {
        List<ProductDTO> listProductDTO = new ArrayList<>();
        List<Product> listProduct = productRepository.findAll(pageable).getContent();
        for(Product item : listProduct){
            ProductDTO productDTO = modelMapper.map(item,ProductDTO.class);
            listProductDTO.add(productDTO);
        }
        return listProductDTO;
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> listProduct = productRepository.findAll();
        List<ProductDTO> listProductDTO = modelMapper.map(listProduct, new TypeToken<List<ProductDTO>>(){}.getType());
        return listProductDTO;
    }

    @Override
    public ProductDTO findById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        return modelMapper.map(product.get(),ProductDTO.class);
    }

    @Override
    public int totalItem() {
        return (int) productRepository.count();
    }
}
