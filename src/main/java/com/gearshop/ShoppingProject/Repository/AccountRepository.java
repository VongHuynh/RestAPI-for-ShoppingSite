package com.gearshop.ShoppingProject.Repository;

import com.gearshop.ShoppingProject.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Integer>{
    @Query("SELECT DISTINCT ar.account  FROM Authority ar WHERE ar.role.id IN ('ADMIN')")
    List<Account> getAdministrators();
    Account findByUserNameEquals(String username);
}
