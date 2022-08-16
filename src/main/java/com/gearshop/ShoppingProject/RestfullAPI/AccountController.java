package com.gearshop.ShoppingProject.RestfullAPI;

import com.gearshop.ShoppingProject.DTO.AccountDTO;
import com.gearshop.ShoppingProject.Entity.Account;
import com.gearshop.ShoppingProject.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping()
    public AccountDTO createAccount(@RequestBody AccountDTO model){
        return accountService.save(model);
    }
    @PreAuthorize("isAuthenticated")
    @PutMapping("/{id}")
    public AccountDTO updateAccount(@RequestBody AccountDTO model, @PathVariable("id") String id) {
        model.setUserName(id);
        return accountService.save(model);
    }

    @GetMapping("findUsername")
    public Account findAccount(@RequestParam("username") String username) {
        return accountService.findByUsername(username);
    }

    @GetMapping("findId/{id}")
    public AccountDTO findByID(@PathVariable("id") Integer id) {
        System.out.println("findAccount: " + accountService.findById(id));
        return accountService.findById(id);
    }
}
