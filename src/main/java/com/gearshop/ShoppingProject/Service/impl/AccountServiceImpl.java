package com.gearshop.ShoppingProject.Service.impl;

import com.gearshop.ShoppingProject.DTO.AccountDTO;
import com.gearshop.ShoppingProject.Entity.Account;
import com.gearshop.ShoppingProject.Repository.AccountRepository;
import com.gearshop.ShoppingProject.Service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public AccountDTO save(AccountDTO accountDTO) {
        Account newAccount = new Account();
        if (accountDTO.getId() != null) {
            Optional<Account> oldAccount = accountRepository.findById(accountDTO.getId());
            newAccount = modelMapper.map(accountDTO, oldAccount.get().getClass());
        } else {
            newAccount = modelMapper.map(accountDTO, Account.class);
        }
        newAccount = accountRepository.save(newAccount);
        return modelMapper.map(newAccount, AccountDTO.class);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public AccountDTO findById(Integer id) {
        Optional<Account> account= accountRepository.findById(id);
        return modelMapper.map(account.get(), AccountDTO.class);
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUserNameEquals(username);
    }

    @Override
    public List<Account> getAdministrators() {
        return accountRepository.getAdministrators();
    }
}
