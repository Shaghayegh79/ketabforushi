package com.example.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.account.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	Account findByUsername(String username);


}
