package com.example.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.account.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
