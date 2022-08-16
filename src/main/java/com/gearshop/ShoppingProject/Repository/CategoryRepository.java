package com.gearshop.ShoppingProject.Repository;

import com.gearshop.ShoppingProject.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
