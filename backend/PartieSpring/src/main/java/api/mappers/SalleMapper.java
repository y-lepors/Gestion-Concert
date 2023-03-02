package api.mappers;

import api.dtos.SalleDTO;
import api.entities.Salle;
import org.springframework.stereotype.Component;

/**
 *
 Cette classe représente le mapper SalleMapper qui permet de mapper l'entité Salle et le DTO SalleDTO.
 */
@Component
public class SalleMapper {

    public SalleDTO toDTO(Salle salle){
        SalleDTO salleDTO = new SalleDTO();
        salleDTO.setIdSalle(salle.getIdSalle());
        salleDTO.setNom(salle.getNom());
        salleDTO.setAdresse(salle.getAdresse());
        salleDTO.setCapacite(salle.getCapacite());
        salleDTO.setConcerts(salle.getConcerts());
        salleDTO.setSoirees(salle.getSoirees());
        salleDTO.setGestionnaire(salle.getGestionnaire());
        return salleDTO;
    }

    public Salle toEntity(SalleDTO salleDTO){
        Salle salle = new Salle();
        salle.setIdSalle(salleDTO.getIdSalle());
        salle.setNom(salleDTO.getNom());
        salle.setAdresse(salleDTO.getAdresse());
        salle.setCapacite(salleDTO.getCapacite());
        salle.setConcerts(salleDTO.getConcerts());
        salle.setSoirees(salleDTO.getSoirees());
        salle.setGestionnaire(salleDTO.getGestionnaire());
        return salle;
    }
}