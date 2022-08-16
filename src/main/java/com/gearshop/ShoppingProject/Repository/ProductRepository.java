package com.gearshop.ShoppingProject.Repository;

import com.gearshop.ShoppingProject.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer>{
}
