package com.gearshop.ShoppingProject.RestfullAPI;

import com.gearshop.ShoppingProject.Entity.Role;
import com.gearshop.ShoppingProject.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("roles")
public class RoleController {
    @Autowired
    RoleService roleService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<Role> getAll() {
        return roleService.findAll();
    }
}
