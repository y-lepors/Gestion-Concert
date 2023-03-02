package api.controllers;

import api.dtos.GestionnaireDTO;
import api.services.GestionnaireService;
import org.springframework.web.bind.annotation.*;

/**
 * Cette classe représente le controller GestionnaireController qui permet de gérer les requêtes HTTP relatives à l'entité Gestionnaire.
 */
@RestController
@RequestMapping("/gestionnaires")
public class GestionnaireController {
    private final GestionnaireService gestionnaireService;

    public GestionnaireController(GestionnaireService gestionnaireService) {
        this.gestionnaireService = gestionnaireService;
    }

    @GetMapping("/{idGestionnaire}")
    public GestionnaireDTO getGestionnaire(@PathVariable Long idGestionnaire) {
        return gestionnaireService.getGestionnaire(idGestionnaire);
    }

    @PostMapping
    public GestionnaireDTO createGestionnaire(@RequestBody GestionnaireDTO gestionnaireDTO) {
        return gestionnaireService.createGestionnaire(gestionnaireDTO);
    }

    @PutMapping("/{idGestionnaire}")
    public GestionnaireDTO updateGestionnaire(@PathVariable Long idGestionnaire, @RequestBody GestionnaireDTO gestionnaireDTO) {
        return gestionnaireService.updateGestionnaire(idGestionnaire, gestionnaireDTO);
    }

    @DeleteMapping("/{idGestionnaire}")
    public void deleteGestionnaire(@PathVariable Long idGestionnaire) {
        gestionnaireService.deleteGestionnaire(idGestionnaire);
    }


}