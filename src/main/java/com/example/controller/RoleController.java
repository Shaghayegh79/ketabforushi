package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.RoleService;

@RestController
@CrossOrigin

public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/roles/{id}")
	public ResponseEntity<String> getCode(@PathVariable int id){
		return new ResponseEntity<String>(roleService.getRole(id).getCode(), HttpStatus.OK);
		
	}
	
}
