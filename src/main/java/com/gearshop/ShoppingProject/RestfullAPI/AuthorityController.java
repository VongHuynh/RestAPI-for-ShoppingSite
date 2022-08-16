package com.gearshop.ShoppingProject.RestfullAPI;

import com.gearshop.ShoppingProject.Entity.Authority;
import com.gearshop.ShoppingProject.Service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("authorities")
public class AuthorityController {
    @Autowired
    AuthorityService authorityService;

    @PostMapping
    public Authority post(@RequestBody Authority auth) {
        return authorityService.create(auth);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        authorityService.delete(id);
    }
}
