package com.ferraz.despensalivre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ferraz.despensalivre.model.Condominium;
import com.ferraz.despensalivre.repository.CondominiumRepository;

@RestController
@RequestMapping("/api/condominium")
public class CondominiumController {

	@Autowired
	private CondominiumRepository repository;
	
	
	@PostMapping("/save")
	public String save(@RequestBody Condominium obj) {
		repository.save(obj);
		
		return "Condominium " + obj.getName() + " saved!";
	}
	
	@GetMapping("/find-by-id")
	public Condominium findById(@RequestParam Integer id) {
		return repository.findById(id).get();
	}
	
	@GetMapping("/all")
	public Iterable<Condominium> getAll() {
		return repository.findAll();
	}
	
}
