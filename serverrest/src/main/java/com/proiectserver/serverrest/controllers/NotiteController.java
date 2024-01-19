package com.proiectserver.serverrest.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.proiectserver.serverrest.entities.Notita;
import com.proiectserver.serverrest.repositories.NotiteRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/notita")
public class NotiteController {
    @Autowired
    private NotiteRepository repository;


    @GetMapping("/{id}")
    public Optional<Notita> primesteNotita (@PathVariable Long id) {
        return repository.findById(id);
    }

    @GetMapping("/toate")
    public List<Notita> primesteToateNotitele (@RequestParam(required = false) String autor) {
        if (autor != null) {
            return repository.findByAutor(autor);
        } else {
            return repository.findAll();
        }
    }
    

    @PostMapping("/publica")
    public ResponseEntity<HttpStatus> publicaNotita (@RequestBody Notita oNotita) {
        repository.save(oNotita);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
