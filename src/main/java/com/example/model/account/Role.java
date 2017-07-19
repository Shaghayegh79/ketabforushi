package com.example.model.account;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;
//@CrossOrigin
@Entity
@Table(name = "tab_role",schema="utente")

public class Role {

	@Id @GeneratedValue
	private int id;
	
	@NotNull
	private String code;
	
	@NotNull
	private String label;
	
	@OneToMany(mappedBy="role",fetch = FetchType.EAGER)
	private Set<RolePerAccount> rolesPerAccount;
	
	public Role(){
		
	}
	public Role(int id, String code, String label, Set<RolePerAccount> rolesPerAccount) {
		//super();
		this.id = id;
		this.code = code;
		this.label = label;
		this.rolesPerAccount = rolesPerAccount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	@XmlTransient
	@JsonIgnore
	public Set<RolePerAccount> getRolesPerAccount() {
		return rolesPerAccount;
	}
	public void setRolesPerAccount(Set<RolePerAccount> rolesPerAccount) {
		this.rolesPerAccount = rolesPerAccount;
	}
}