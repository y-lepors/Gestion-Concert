package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtos.SalleDto;

@RestController
@RequestMapping("/salles")
public class SalleController {

    @Autowired
    private SalleServiceImpl salleService;

    @GetMapping("")
    public List<SalleDto> getAllSalles() {
        return salleService.getAllSalles();
    }

    @GetMapping("/{idSalle}")
    public SalleDto getSalleById(@PathVariable Long idSalle) {
        return salleService.getSalleById(idSalle);
    }

    @PostMapping("")
    public ResponseEntity<SalleDto> createSalle(@RequestBody SalleDto salleDto) {
        SalleDto newSalle = salleService.createSalle(salleDto);
        return new ResponseEntity<>(newSalle, HttpStatus.CREATED);
    }

    @PutMapping("/{idSalle}")
    public SalleDto updateSalle(@PathVariable Long idSalle, @RequestBody SalleDto salleDto) {
        return salleService.updateSalle(idSalle, salleDto);
    }

    @DeleteMapping("/{idSalle}")
    public void deleteSalle(@PathVariable Long idSalle) {
        salleService.deleteSalle(idSalle);
    }
}


