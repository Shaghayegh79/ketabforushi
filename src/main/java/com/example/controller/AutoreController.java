package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.autore.Autore;
import com.example.service.AutoreService;

@RestController
@CrossOrigin

public class AutoreController {

	@Autowired
	private AutoreService autoreService;
	
	@GetMapping("/autori")
	public ResponseEntity<List<Autore>> getListaAutori(){
		return new ResponseEntity<List<Autore>>(autoreService.getListaAutori(),HttpStatus.OK);
	}
}
