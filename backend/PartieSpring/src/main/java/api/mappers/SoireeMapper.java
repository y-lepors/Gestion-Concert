package api.mappers;

import api.dtos.SoireeDTO;
import api.entities.Soiree;
import org.springframework.stereotype.Component;

@Component
public class SoireeMapper {
	public SoireeDTO toDTO(Soiree soiree) {
		SoireeDTO soireeDTO = new SoireeDTO();
		soireeDTO.setIdSoiree(soiree.getIdSoiree());
		soireeDTO.setNom(soiree.getNom());
		soireeDTO.setSalle(soiree.getSalle());
		soireeDTO.setConcerts(soiree.getConcerts());
		return soireeDTO;
	}

	public Soiree toEntity(SoireeDTO soireeDTO) {
		Soiree soiree = new Soiree();
		soiree.setIdSoiree(soireeDTO.getIdSoiree());
		soiree.setNom(soireeDTO.getNom());
		soiree.setSalle(soireeDTO.getSalle());
		soiree.setConcerts(soireeDTO.getConcerts());
		return soiree;
	}
}

