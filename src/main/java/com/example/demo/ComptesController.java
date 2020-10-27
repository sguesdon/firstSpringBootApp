package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComptesController {
	
	@GetMapping("/api/comptes")
	public ResponseEntity<String> getComptes() {
		return new ResponseEntity<>("get comptes", HttpStatus.OK);
	}
	
	@GetMapping("/api/comptes/{id}")
	public ResponseEntity<String> getComptesById(@PathVariable Long id) {
		return new ResponseEntity<>(
			String.format("get comptes by id %d", id),
			HttpStatus.OK
		);
	}
	
	@PostMapping("/api/comptes")
	public ResponseEntity<String> postComptes() {
		return new ResponseEntity<>(
			"post comptes",
			HttpStatus.CREATED
		);
	}
	
	@PutMapping("/api/comptes/{id}")
	public ResponseEntity<String> putComptes(@PathVariable Long id) {
		return new ResponseEntity<>(
			String.format("put comptes with id %d", id),
			HttpStatus.OK
		);
	}
	
	@DeleteMapping("/api/comptes/{id}")
	public ResponseEntity<String> deleteComptes(@PathVariable Long id) {
		return new ResponseEntity<>(
			String.format("delete comptes with id %d", id),
			HttpStatus.OK
		);
	}
}
