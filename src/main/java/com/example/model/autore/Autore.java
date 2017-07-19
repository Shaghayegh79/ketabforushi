package com.example.model.autore;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="tab_autore",schema = "libreria")
public class Autore {
	@GeneratedValue @Id
	private Integer id;
	@NotNull
	private String autore;
	@Column(name="età")
	private short age;
	@Column(name="nickname")
	private String nickName;
	@OneToMany
	@JoinColumn(name="tab_autore_id")
	private Set<Libro> libri;
	public Autore(){
		
	}
	public Autore(Integer id, String autore, short age, String nickName, Set<Libro> libri) {
		this.id = id;
		this.autore = autore;
		this.age = age;
		this.nickName = nickName;
		this.libri = libri;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public short getAge() {
		return age;
	}
	public void setAge(short age) {
		this.age = age;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Set<Libro> getLibri() {
		return libri;
	}
	public void setLibri(Set<Libro> libri) {
		this.libri = libri;
	}
	
	
}
