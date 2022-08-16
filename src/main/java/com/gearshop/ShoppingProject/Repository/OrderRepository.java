package com.gearshop.ShoppingProject.Repository;

import com.gearshop.ShoppingProject.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
    @Query("SELECT o FROM Orders o WHERE o.account.userName=?1")
    List<Orders> findByUsername(String username);
}
