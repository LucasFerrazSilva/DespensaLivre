package com.ferraz.despensalivre.controller;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferraz.despensalivre.model.User;
import com.ferraz.despensalivre.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	
	@GetMapping("/")
	public ResponseEntity<Iterable<User>> getAll(){
		List<User> list = repository.findAll();
		
		return new ResponseEntity<>(list, OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> get(@PathVariable Integer id){
		User obj = repository.findById(id).get();
		
		return new ResponseEntity<>(obj, OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<String> save(@Valid @RequestBody User user){
		repository.save(user);
		
		return new ResponseEntity<>(OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Iterable<User>> remove(@PathVariable Integer id){
		repository.deleteById(id);
		
		return new ResponseEntity<>(OK);
	}
	
}
