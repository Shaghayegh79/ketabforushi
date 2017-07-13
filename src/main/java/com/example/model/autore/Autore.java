package com.example.model.autore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tab_autore",schema = "libreria")
public class Autore {
	@GeneratedValue @Id
	private Integer id;
	@NotNull
	private String autore;
	private byte età;
	@Column(name="nickname")
	private String nickName;
	public Autore(Integer id, String autore, byte età, String nickName) {
		super();
		this.id = id;
		this.autore = autore;
		this.età = età;
		this.nickName = nickName;
	}
	public Autore() {
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
	public byte getEtà() {
		return età;
	}
	public void setEtà(byte età) {
		this.età = età;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
}
