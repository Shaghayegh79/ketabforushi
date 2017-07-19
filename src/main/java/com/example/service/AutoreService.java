package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.example.model.autore.Autore;
import com.example.repository.autore.AutoreRepository;

@Service
public class AutoreService {
	@Autowired
	private AutoreRepository autoreRepository; 
	
	@Cacheable("listaAutori")
	public List<Autore> getListaAutori(){
		List<Autore> listaAutori=(List<Autore>)autoreRepository.findAll();
		return listaAutori;
	}
}
