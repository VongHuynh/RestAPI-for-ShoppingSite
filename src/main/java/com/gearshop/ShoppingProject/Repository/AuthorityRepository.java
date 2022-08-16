package com.gearshop.ShoppingProject.Repository;

import com.gearshop.ShoppingProject.Entity.Account;
import com.gearshop.ShoppingProject.Entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority,Integer> {
    @Query("SELECT DISTINCT a FROM Authority a WHERE a.account IN ?1")
    List<Authority> authoritiesOf(List<Account> account);
}
