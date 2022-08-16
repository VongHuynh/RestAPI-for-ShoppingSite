package com.gearshop.ShoppingProject.Service;

import com.gearshop.ShoppingProject.DTO.AccountDTO;
import com.gearshop.ShoppingProject.Entity.Account;

import java.util.List;

public interface AccountService {
    AccountDTO save(AccountDTO accountDTO);
    List<Account> findAll() ;
    AccountDTO findById(Integer id) ;
    Account findByUsername(String username) ;
    List<Account> getAdministrators() ;
}
