package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Compte;

public interface CompteRepository extends CrudRepository<Compte, Integer>{

}