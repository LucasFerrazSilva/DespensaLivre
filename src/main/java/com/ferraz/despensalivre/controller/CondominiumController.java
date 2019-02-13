package com.ferraz.despensalivre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ferraz.despensalivre.model.Condominium;
import com.ferraz.despensalivre.repository.CondominiumRepository;

@Controller
@RequestMapping("/condominium")
public class CondominiumController {

	@Autowired
	private CondominiumRepository repository;
	
	
	@PostMapping("/save")
	@ResponseBody
	public String save(Condominium obj) {
		repository.save(obj);
		
		return "Condominium " + obj.getName() + " saved!";
	}
	
	@GetMapping("/find-by-id")
	@ResponseBody
	public Condominium findById(@RequestParam Integer id) {
		return repository.findById(id).get();
	}
	
	@GetMapping("/all")
	@ResponseBody
	public Iterable<Condominium> getAll() {
		return repository.findAll();
	}
	
}
