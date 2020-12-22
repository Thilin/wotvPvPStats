package com.example.mxhStudio.WotVPvPStats.services.Impl;

import com.example.mxhStudio.WotVPvPStats.domain.CharacterBuilt;
import com.example.mxhStudio.WotVPvPStats.domain.CharacterBuiltEquipments;
import com.example.mxhStudio.WotVPvPStats.domain.CharacterJob;
import com.example.mxhStudio.WotVPvPStats.exceptions.ObjectNotFoundException;
import com.example.mxhStudio.WotVPvPStats.projections.dto.CharacterBuiltDTO;
import com.example.mxhStudio.WotVPvPStats.projections.dto.CharacterBuiltEquipmentDTO;
import com.example.mxhStudio.WotVPvPStats.projections.dto.CharacterBuiltResponseDTO;
import com.example.mxhStudio.WotVPvPStats.repositories.*;
import com.example.mxhStudio.WotVPvPStats.services.CharacterBuiltService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterBuiltServiceImpl implements CharacterBuiltService {

    @Autowired
    EsperRepository esperRepository;
    @Autowired
    CharacterRepository characterRepository;
    @Autowired
    VisionCardRepository visionCardRepository;
    @Autowired
    CharacterBuiltRepository characterBuiltRepository;
    @Autowired
    EquipmentRepository equipmentRepository;
    @Autowired
    CharacterBuiltEquipmentRepository characterBuiltEquipmentRepository;
    @Autowired
    CharacterJobRepository characterJobRepository;

    @Override
    public CharacterBuiltResponseDTO build(CharacterBuiltDTO dto) {
        var dtoResponse = new CharacterBuiltResponseDTO();
        var esper = esperRepository.findById(dto.getEsperId()).orElseThrow(() -> new ObjectNotFoundException("Esper not found"));
        var visionCard = visionCardRepository.findById(dto.getVisionCardId()).orElseThrow(() -> new ObjectNotFoundException("Vision Card not Found"));
        var character = characterRepository.findById(dto.getCharacterId()).orElseThrow(() -> new ObjectNotFoundException("Character not found"));
        var characterBuilt = new CharacterBuilt();
        List<CharacterBuiltEquipmentDTO> charEquips = new ArrayList<>();

        characterBuilt.setCharacter(character);
        characterBuilt.setEsper(esper);
        characterBuilt.setVisionCard(visionCard);
        characterBuilt.setName(dto.getName());
        characterBuilt.setSecundaryJob(characterJobRepository.findById(dto.getJobSecundaryId()).orElseThrow(() -> new ObjectNotFoundException("Secundary job not found")).getJob().getDescription());
        characterBuiltRepository.save(characterBuilt);
        dto.getEquipments().forEach(equipmentBuilderDTO -> {
            var characterBuiltEquipments = new CharacterBuiltEquipments();
            var charEquipDTO = new CharacterBuiltEquipmentDTO();
            var equipment = equipmentRepository.findById(equipmentBuilderDTO.getId()).orElseThrow(() -> new ObjectNotFoundException("Equipment not found"));
            characterBuiltEquipments.setCharacterBuilt(characterBuilt);
            characterBuiltEquipments.setEquipment(equipment);
            characterBuiltEquipments.setPlus(equipmentBuilderDTO.getPlus());
            characterBuiltEquipmentRepository.save(characterBuiltEquipments);
            charEquipDTO.setName(equipment.getName());
            charEquipDTO.setType(equipment.getEquipmentType().getDescription());
            charEquipDTO.setPlus(equipmentBuilderDTO.getPlus());
            charEquips.add(charEquipDTO);
        });
        dtoResponse.setId(characterBuilt.getId());
        dtoResponse.setCharacterName(characterBuilt.getCharacter().getName());
        dtoResponse.setEsperName(characterBuilt.getEsper().getName());
        dtoResponse.setVisionCardName(characterBuilt.getVisionCard().getName());
        dtoResponse.setName(characterBuilt.getName());
        dtoResponse.setSecundaryJob(characterBuilt.getSecundaryJob());
        dtoResponse.setEquipments(charEquips);
        return dtoResponse;
    }

    @Override
    public CharacterBuiltResponseDTO findById(Long id) {
        var dto = new CharacterBuiltResponseDTO();
        var charBuilt = characterBuiltRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Character not found"));
        List<CharacterBuiltEquipmentDTO> dtos = new ArrayList<>();

        dto.setName(charBuilt.getName());
        dto.setVisionCardName(charBuilt.getVisionCard().getName());
        dto.setSecundaryJob(charBuilt.getSecundaryJob());
        dto.setEsperName(charBuilt.getEsper().getName());
        dto.setCharacterName(charBuilt.getCharacter().getName());
        dto.setId(charBuilt.getId());

        List<CharacterBuiltEquipments> characterBuiltEquipments = characterBuiltEquipmentRepository.findByCharacterBuiltId(charBuilt.getId());
        characterBuiltEquipments.forEach(characterBuiltEquipment -> {
            var charEquipDTO = new  CharacterBuiltEquipmentDTO();
            charEquipDTO.setName(characterBuiltEquipment.getEquipment().getName());
            charEquipDTO.setPlus(characterBuiltEquipment.getPlus());
            charEquipDTO.setType(characterBuiltEquipment.getEquipment().getEquipmentType().getDescription());
            dtos.add(charEquipDTO);
        });
        dto.setEquipments(dtos);
        return dto;
    }

    @Override
    public List<CharacterBuiltResponseDTO> findAll() {
        List<CharacterBuilt> builts = characterBuiltRepository.findAll();
        List<CharacterBuiltResponseDTO> responseDTO = new ArrayList<>();

        builts.forEach(built -> {
            var dto = new CharacterBuiltResponseDTO();
            List<CharacterBuiltEquipmentDTO> dtos = new ArrayList<>();

            dto.setName(built.getName());
            dto.setVisionCardName(built.getVisionCard().getName());
            dto.setSecundaryJob(built.getSecundaryJob());
            dto.setEsperName(built.getEsper().getName());
            dto.setCharacterName(built.getCharacter().getName());
            dto.setId(built.getId());

            List<CharacterBuiltEquipments> characterBuiltEquipments = characterBuiltEquipmentRepository.findByCharacterBuiltId(built.getId());
            characterBuiltEquipments.forEach(characterBuiltEquipment -> {
                var charEquipDTO = new  CharacterBuiltEquipmentDTO();
                charEquipDTO.setName(characterBuiltEquipment.getEquipment().getName());
                charEquipDTO.setPlus(characterBuiltEquipment.getPlus());
                charEquipDTO.setType(characterBuiltEquipment.getEquipment().getEquipmentType().getDescription());
                dtos.add(charEquipDTO);
            });
            dto.setEquipments(dtos);
            responseDTO.add(dto);
        });
        return responseDTO;
    }
}
