package com.example.model.autore;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tab_libro",schema = "libreria")
public class Libro {
	@GeneratedValue @Id
	private Integer id;
	@NotNull
	private String titolo;
	private short anno;
	private short pagine;
	private BigDecimal prezzo;
	private byte sconto;
	private String info;
	private String editore;
	private String collana;
	private String isbn;
	private String immagine;

	@Column(name="tab_autore_id")
	private Integer idAutore;
	public Libro(){
	}
	
	public Libro(Integer id, String titolo, short anno, short pagine, BigDecimal prezzo, byte sconto, String info,
			String editore, String collana, String isbn, String immagine, Integer idAutore) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.anno = anno;
		this.pagine = pagine;
		this.prezzo = prezzo;
		this.sconto = sconto;
		this.info = info;
		this.editore = editore;
		this.collana = collana;
		this.isbn = isbn;
		this.immagine = immagine;
		this.idAutore = idAutore;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public short getAnno() {
		return anno;
	}

	public void setAnno(short anno) {
		this.anno = anno;
	}

	public short getPagine() {
		return pagine;
	}

	public void setPagine(short pagine) {
		this.pagine = pagine;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}

	public byte getSconto() {
		return sconto;
	}

	public void setSconto(byte sconto) {
		this.sconto = sconto;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getEditore() {
		return editore;
	}

	public void setEditore(String editore) {
		this.editore = editore;
	}

	public String getCollana() {
		return collana;
	}

	public void setCollana(String collana) {
		this.collana = collana;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	public Integer getIdAutore() {
		return idAutore;
	}

	public void setIdAutore(Integer idAutore) {
		this.idAutore = idAutore;
	}

}
