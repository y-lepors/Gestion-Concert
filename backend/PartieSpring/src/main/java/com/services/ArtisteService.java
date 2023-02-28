package com.services;

import com.dtos.ArtisteDTO;

import java.util.List;

public interface ArtisteService {
    ArtisteDTO saveArtiste(ArtisteDTO artisteDTO);

    ArtisteDTO getArtisteById(Integer id);

    boolean deleteArtiste(Integer id);

    List<ArtisteDTO> getAllArtistes();


}
