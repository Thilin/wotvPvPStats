package com.example.mxhStudio.WotVPvPStats.services;

import com.example.mxhStudio.WotVPvPStats.projections.dto.CharacterBuiltDTO;
import com.example.mxhStudio.WotVPvPStats.projections.dto.CharacterBuiltResponseDTO;

import java.util.List;

public interface CharacterBuiltService {
    CharacterBuiltResponseDTO build(CharacterBuiltDTO dto);

    CharacterBuiltResponseDTO findById(Long id);

    List<CharacterBuiltResponseDTO> findAll();
}
