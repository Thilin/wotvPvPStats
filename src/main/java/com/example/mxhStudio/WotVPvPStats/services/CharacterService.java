package com.example.mxhStudio.WotVPvPStats.services;

import com.example.mxhStudio.WotVPvPStats.domain.Character;
import com.example.mxhStudio.WotVPvPStats.projections.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {
    List<Character> findAll();

    CharacterDTO findById(Long id);
}
