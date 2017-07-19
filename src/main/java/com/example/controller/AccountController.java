package com.example.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.account.Account;
import com.example.service.AccountService;


@RestController
@CrossOrigin
//test
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping("/utenti")
	public ResponseEntity<List<Account>> getListaUtenti(){
		return new ResponseEntity<List<Account>>(accountService.getListaUtenti(),HttpStatus.OK);
	}
}


