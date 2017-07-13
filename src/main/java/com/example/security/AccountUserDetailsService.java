package com.example.security;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpSession;

import com.example.model.account.Account;
import com.example.model.account.Role;
import com.example.model.account.RolePerAccount;
import com.example.repository.account.RoleRepository;
import com.example.service.AccountService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Session;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
//@CrossOrigin
public class AccountUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleRepository roleRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        logger.info("> loadUserByUsername {}", username);
        Account account = accountService.getAccount(username);
//        idCliente= account.getCliente_id();
        

        if (account == null) {
            // Not found...
            throw new UsernameNotFoundException(
                    "User " + username + " not found.");
        }

        if (account.getRolesPerAccount() == null || account.getRolesPerAccount().isEmpty()) {
            // No Roles assigned to user...
            throw new UsernameNotFoundException("User not authorized.");
        }

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        for (RolePerAccount rolePerAccount : account.getRolesPerAccount()) {
        	
            grantedAuthorities.add(new SimpleGrantedAuthority(roleRepository.findOne(rolePerAccount.getRole_id()).getCode()));
        }
        User userDetails = new User(account.getUsername(),
                account.getPassword(), account.isEnabled(),
                !account.isExpired(), !account.isCredentialsexpired(),
                !account.isLocked(), grantedAuthorities);
        logger.info("< loadUserByUsername {}", username);
        return userDetails;
    }

}