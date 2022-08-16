package com.gearshop.ShoppingProject.Service.impl;

import com.gearshop.ShoppingProject.Entity.Role;
import com.gearshop.ShoppingProject.Repository.RoleRepository;
import com.gearshop.ShoppingProject.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
