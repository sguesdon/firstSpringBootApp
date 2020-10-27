package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repository.CompteRepository;
import com.example.demo.model.Compte;

@RestController
@RequestMapping(path="/api/comptes")
public class ComptesController {
	
	@Autowired
	private CompteRepository compteRepository;
	
	@GetMapping()
	public @ResponseBody Iterable<Compte> getComptes() {
		return compteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Compte> getComptesById(@PathVariable Long id) {
		
		Optional<Compte> compte = compteRepository.findById(id.intValue());
		
		if(!compte.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return new ResponseEntity<>(compte.get(), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Compte> post(@Validated @RequestBody Compte compte) {
		compte = compteRepository.save(compte);
		return new ResponseEntity<>(compte, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Compte> put(@PathVariable Long id, @Validated @RequestBody Compte compte) {
		
		if(!compteRepository.existsById(id.intValue())) {
			return ResponseEntity.notFound().build();
		}
		
		compte.setId(id.intValue());
		compteRepository.save(compte);
		return new ResponseEntity<>(compte, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteComptes(@PathVariable Long id) {
		
		if(!compteRepository.existsById(id.intValue())) {
			return ResponseEntity.notFound().build();
		}
		
		compteRepository.deleteById(id.intValue());
		return ResponseEntity.noContent().build();
	}
}
