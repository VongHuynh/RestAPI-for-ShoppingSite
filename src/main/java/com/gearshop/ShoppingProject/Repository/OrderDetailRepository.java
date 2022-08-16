package com.gearshop.ShoppingProject.Repository;

import com.gearshop.ShoppingProject.Entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
