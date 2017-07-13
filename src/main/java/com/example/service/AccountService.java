package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.account.Account;
import com.example.repository.account.AccountRepository;
//@CrossOrigin
@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	public Account addAccount(Account account)
	{
		accountRepository.save(account);
		return account;		
	}

	public List<Account> getListaUtenti()
	{
		return (List<Account>)accountRepository.findAll();
	}
	
	public Account getAccount(String username)
	{
		return accountRepository.findByUsername(username);
	}

}
