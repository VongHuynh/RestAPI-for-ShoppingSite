package com.gearshop.ShoppingProject.Service;

import com.gearshop.ShoppingProject.Entity.Authority;

import java.util.List;

public interface AuthorityService {
    List<Authority> findAll();
    Authority create(Authority auth) ;
    void delete(Integer id) ;
    List<Authority> findAuthoritiesOfAdministrators() ;
}
