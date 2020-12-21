package com.example.mxhStudio.WotVPvPStats.services.Impl;

import com.example.mxhStudio.WotVPvPStats.domain.Character;
import com.example.mxhStudio.WotVPvPStats.exceptions.ObjectNotFoundException;
import com.example.mxhStudio.WotVPvPStats.projections.dto.CharacterDTO;
import com.example.mxhStudio.WotVPvPStats.repositories.CharacterRepository;
import com.example.mxhStudio.WotVPvPStats.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public List<Character> findAll() {
        return characterRepository.findAll();
    }

    @Override
    public CharacterDTO findById(Long id) {
        var character = characterRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Personagem não encontrado"));
        var dto = new CharacterDTO();
        dto.setId(character.getId());
        dto.setName(character.getName());
        dto.setImage(character.getImage());
        dto.setRarity(character.getRarity());
        return dto;
    }
}
