package api.controllers;

import api.dtos.SoireeDTO;
import api.services.SoireeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/soirees")
public class SoireeController {
	
	private final SoireeService soireeService;

	public SoireeController(SoireeService soireeService) {
		this.soireeService = soireeService;
	}

	@GetMapping
	public ResponseEntity<List<SoireeDTO>> getSoirees() {
		List<SoireeDTO> soirees = soireeService.getAllSoirees();
		if (soirees.isEmpty()) {
			return ResponseEntity.noContent()
					.header("Access-Control-Allow-Origin", "http://localhost:5173")
					.build();
		}
		return ResponseEntity.ok()
				.header("Access-Control-Allow-Origin", "http://localhost:5173")
				.body(soirees);
	}

	@GetMapping("/{id}")
	public ResponseEntity<SoireeDTO> getSoiree(@PathVariable Long id){
		SoireeDTO soiree = soireeService.getSoireeById(id);
		if (soiree == null) {
			return ResponseEntity.noContent()
					.header("Access-Control-Allow-Origin", "http://localhost:5173")
					.build();
		}
		return ResponseEntity.ok()
				.header("Access-Control-Allow-Origin", "http://localhost:5173")
				.body(soiree);
	}

	@PostMapping
	public ResponseEntity<SoireeDTO> saveSoiree(final @RequestBody SoireeDTO soireeDTO){
		SoireeDTO soiree = soireeService.saveSoiree(soireeDTO);
		if (soiree == null) {
			return ResponseEntity.noContent()
					.header("Access-Control-Allow-Origin", "http://localhost:5173")
					.build();
		}
		return ResponseEntity.ok()
				.header("Access-Control-Allow-Origin", "http://localhost:5173")
				.body(soiree);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteSoiree(@PathVariable Long id){
		Boolean deleted = soireeService.deleteSoiree(id);
		if (!deleted) {
			return ResponseEntity.noContent()
					.header("Access-Control-Allow-Origin", "http://localhost:5173")
					.build();
		}
		return ResponseEntity.ok()
				.header("Access-Control-Allow-Origin", "http://localhost:5173")
				.body(deleted);
	}

	@PostMapping("/update")
	public ResponseEntity<SoireeDTO> updateSoiree(final @RequestBody SoireeDTO soireeDTO){
		SoireeDTO soiree = soireeService.updateSoiree(soireeDTO);
		if (soiree == null) {
			return ResponseEntity.noContent()
					.header("Access-Control-Allow-Origin", "http://localhost:5173")
					.build();
		}
		return ResponseEntity.ok()
				.header("Access-Control-Allow-Origin", "http://localhost:5173")
				.body(soiree);
	}
}