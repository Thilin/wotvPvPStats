package com.example.mxhStudio.WotVPvPStats.services;

import com.example.mxhStudio.WotVPvPStats.domain.Character;
import com.example.mxhStudio.WotVPvPStats.projections.dto.CharacterDTO;
import com.example.mxhStudio.WotVPvPStats.projections.dto.JobsCharacterDTO;

import java.util.List;

public interface CharacterService {
    List<Character> findAll();

    CharacterDTO findById(Long id);

    JobsCharacterDTO findCharacterJobsById(Long id);
}
