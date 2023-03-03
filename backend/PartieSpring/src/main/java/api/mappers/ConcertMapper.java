package api.mappers;

import api.dtos.ConcertDTO;
import api.entities.Concert;
import org.springframework.stereotype.Component;

/**
 *
 Cette classe représente le mapper ConcertMapper qui permet de mapper l'entité Concert et le DTO ConcertDTO.
 */
@Component
public class ConcertMapper {

    public ConcertDTO toDTO(Concert concert){
        ConcertDTO concertDTO = new ConcertDTO();
        concertDTO.setIdConcert(concert.getIdConcert());
        concertDTO.setDateConcert(concert.getDateConcert());
        concertDTO.setDuree(concert.getDuree());
        concertDTO.setSoiree(concert.getSoiree());
        concertDTO.setSalle(concert.getSalle());
        concertDTO.setNbPlaces(concert.getNbPlaces());
        return concertDTO;
    }

    public Concert toEntity(ConcertDTO concertDTO){
        Concert concert = new Concert();
        concert.setIdConcert(concertDTO.getIdConcert());
        concert.setDateConcert(concertDTO.getDateConcert());
        concert.setDuree(concertDTO.getDuree());
        concert.setSoiree(concertDTO.getSoiree());
        concert.setSalle(concertDTO.getSalle());
        concert.setNbPlaces(concertDTO.getNbPlaces());
        return concert;
    }
}