package com.ferraz.despensalivre.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferraz.despensalivre.model.Condominium;
import com.ferraz.despensalivre.repository.CondominiumRepository;

@RestController
@RequestMapping("/api/condominiums")
public class CondominiumController {

	@Autowired
	private CondominiumRepository repository;
	
	
	@GetMapping("/")
	public ResponseEntity<Iterable<Condominium>> getAll() {
		List<Condominium> list = repository.findAll();
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Condominium> findById(@PathVariable Integer id) {
		Condominium obj = repository.findById(id).get();
		
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<String> save(@Valid @RequestBody Condominium obj) {
		repository.save(obj);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> remove(@PathVariable Integer id) {
		repository.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
