package api.controllers;

import api.dtos.GestionnaireDTO;
import api.services.GestionnaireService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/gestionnaires")
public class GestionnaireController {

    private final GestionnaireService gestionnaireService;

    public GestionnaireController(GestionnaireService gestionnaireService) {
        this.gestionnaireService = gestionnaireService;
    }

    @GetMapping
    public List<GestionnaireDTO> getGestionnaires() {
        return gestionnaireService.getAllGestionnaires();
    }

    @GetMapping("/{id}")
    public GestionnaireDTO getGestionnaire(@PathVariable Long id){
        System.out.println("debut controller");
        return gestionnaireService.getGestionnaireById(id);
    }

    @PostMapping
    public GestionnaireDTO saveGestionnaire(final @RequestBody GestionnaireDTO gestionnaireDTO){
        System.out.println("debut controller");
        return gestionnaireService.saveGestionnaire(gestionnaireDTO);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteGestionnaire(@PathVariable Long id){
        return gestionnaireService.deleteGestionnaire(id);
    }

    @PostMapping("/update")
    public void updateGestionnaire(final @RequestBody GestionnaireDTO gestionnaireDTO){
        gestionnaireService.updateGestionnaire(gestionnaireDTO);
    }
}