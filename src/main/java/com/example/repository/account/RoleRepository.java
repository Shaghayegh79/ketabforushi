package com.example.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.model.account.Role;

//@CrossOrigin
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
