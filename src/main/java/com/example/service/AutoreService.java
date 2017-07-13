package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.autore.Autore;
import com.example.repository.autore.AutoreRepository;

@Service
public class AutoreService {
	@Autowired
	private AutoreRepository autoreRepository; 
	public List<Autore> getListaAutori(){
		return (List<Autore>)autoreRepository.findAll();
	}
}
