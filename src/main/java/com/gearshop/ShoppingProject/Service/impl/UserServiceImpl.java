package com.gearshop.ShoppingProject.Service.impl;

import com.gearshop.ShoppingProject.Entity.Account;
import com.gearshop.ShoppingProject.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    BCryptPasswordEncoder pe;
    @Autowired
    AccountService accountService;

    @Autowired
    HttpSession session;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Account user = accountService.findByUsername(username);
            String password = pe.encode(user.getPassword());
            String[] roles = user.getAuthorities().stream()
                    .map(er -> er.getRole().getId())
                    .collect(Collectors.toList())
                    .toArray(new String[0]);
            Map<String, Object> authentication = new HashMap<>();
            authentication.put("user", user);
            byte[] token = (username + ":" + user.getPassword()).getBytes();
            authentication.put("token", "Basic " + Base64.getEncoder().encodeToString(token));
//          session.setAttribute("authentication", authentication);
            return User.withUsername(username).password(password).roles(roles).build();
        } catch (NoSuchElementException e) {
            throw new UsernameNotFoundException(username + " not found!");
        }
    }

    /*--Mã hóa mật khẩu--*/
    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
