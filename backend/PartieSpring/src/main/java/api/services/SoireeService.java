package api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import api.entities.Salle;
import api.repositories.SalleRepository;
import api.repositories.SoireeRepository;
import api.dtos.SoireeDTO;
import api.entities.Soiree;
import api.mappers.SoireeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class SoireeService {
	@Autowired
	private SoireeRepository soireeRepository;

	@Autowired
	private SoireeMapper soireeMapper;

	/**
	 Cette méthode permet de récupérer toutes les soirées.
	 @return La liste des objets Entity des soirées récupérées.
	 */
	public List<SoireeDTO> getAllSoirees() {
		List<Soiree> soirees = soireeRepository.findAll();
		return soirees.stream().map(soiree -> soireeMapper.toDTO(soiree)).collect(Collectors.toList());
	}

	/**
	 Cette méthode permet de créer une soirée en utilisant un objet DTO et de la sauvegarder en utilisant le repository.
	 @param soireeDTO L'objet DTO contenant les informations de la soirée à créer.
	 @return L'objet Entity de la soirée créée.
	 */
	public SoireeDTO saveSoiree(SoireeDTO soireeDTO) {
		Soiree soiree = soireeMapper.toEntity(soireeDTO);
		soiree = soireeRepository.save(soiree);
		return soireeMapper.toDTO(soiree);
	}

	/**
	 Cette méthode permet de récupérer une soirée en utilisant son identifiant et en utilisant le repository.
	 @param id L'identifiant de la soirée à récupérer.
	 @return L'objet Entity de la soirée récupérée.
	 @throws EntityNotFoundException Si la soirée n'a pas été trouvée avec l'identifiant donné.
	 */
	public SoireeDTO getSoireeById(Long id) {
		Soiree soiree = soireeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Soiree not found"));
		return soireeMapper.toDTO(soiree);
	}

	/**
	 * Cette méthode permet de supprimer une soirée en utilisant son identifiant et en utilisant le repository.
	 * @param id L'identifiant de la soirée à supprimer.
	 */
	public boolean deleteSoiree(Long id) {
		soireeRepository.deleteById(id);
		return true;
	}

	/**
	 Cette méthode permet de mettre à jour une soirée en utilisant son identifiant et en utilisant le repository.
	 @param soireeDTO L'objet DTO contenant les informations de la soirée à mettre à jour.
	 */
	public void updateSoiree(SoireeDTO soireeDTO) {
		Optional<Soiree> oldSoiree = soireeRepository.findById(soireeDTO.getIdSoiree());
		if (oldSoiree.isEmpty()) throw new EntityNotFoundException("Soiree not found");
		Soiree soiree = oldSoiree.get();
		soiree.setSalle(soireeDTO.getSalle());
		soiree.setNom(soireeDTO.getNom());
		soiree.setConcerts(soireeDTO.getConcerts());
		soireeRepository.save(soiree);
	}
}