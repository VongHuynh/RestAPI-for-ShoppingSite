package com.gearshop.ShoppingProject.Service.impl;

import com.gearshop.ShoppingProject.Entity.Authority;
import com.gearshop.ShoppingProject.Repository.AuthorityRepository;
import com.gearshop.ShoppingProject.Service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("authorities")
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    AuthorityRepository authorityRepository;

    @Override
    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }

    @Override
    public Authority create(Authority auth) {
        return authorityRepository.save(auth);
    }

    @Override
    public void delete(Integer id) {
        authorityRepository.deleteById(id);
    }

    @Override
    public List<Authority> findAuthoritiesOfAdministrators() {
        return null;
    }
}
