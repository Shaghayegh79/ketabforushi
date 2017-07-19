package com.example.model.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;
//@CrossOrigin
@Entity
@Table(name = "tab_account_role",schema="utente")

public class RolePerAccount {
	@Id @GeneratedValue
	private Long id;
	
	@Column(name="tab_account_id",insertable = true, updatable = true)
	private Long account_id;
	
	@ManyToOne
	@JoinColumn(name="tab_account_id",insertable = false, updatable = false)
	private Account account;
	
	@Column(name="tab_role_id",insertable = true, updatable = true)
	private int role_id;
	
	@ManyToOne
	@JoinColumn(name="tab_role_id",insertable = false, updatable = false)
	private Role role;

	public RolePerAccount() {
		//super();
	}



	public RolePerAccount(Long id, Long account_id, Account account, int role_id, Role role) {
		//super();
		this.id = id;
		this.account_id = account_id;
		this.account = account;
		this.role_id = role_id;
		this.role = role;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Long account_id) {
		this.account_id = account_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
	

}
