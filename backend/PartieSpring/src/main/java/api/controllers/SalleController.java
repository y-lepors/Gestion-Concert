package api.controllers;

import api.dtos.SalleDTO;
import api.services.SalleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/salles")
public class SalleController {

    private final SalleService salleService;

    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @GetMapping
    public List<SalleDTO> getSalles() {
        return salleService.getAllSalles();
    }

    @GetMapping("/{id}")
    public SalleDTO getSalle(@PathVariable Long id){
        return salleService.getSalleById(id);
    }

    @PostMapping
    public SalleDTO saveSalle(final @RequestBody SalleDTO salleDTO){
        return salleService.saveSalle(salleDTO);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteSalle(@PathVariable Long id){
        return salleService.deleteSalle(id);
    }

    @PostMapping("/update")
    public void updateSalle(final @RequestBody SalleDTO salleDTO){
        salleService.updateSalle(salleDTO);
    }
}