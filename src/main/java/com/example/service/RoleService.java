package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.account.Role;
import com.example.repository.account.RoleRepository;

//@CrossOrigin
@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;
	public Role getRole(int id){
		return roleRepository.findOne(id);
	}

}
