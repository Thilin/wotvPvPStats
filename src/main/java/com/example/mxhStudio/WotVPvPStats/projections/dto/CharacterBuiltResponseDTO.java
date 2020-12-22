package com.example.mxhStudio.WotVPvPStats.projections.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterBuiltResponseDTO {

    private Long id;
    private String name;
    private String characterName;
    private String visionCardName;
    private String esperName;
    private String secundaryJob;
    private List<CharacterBuiltEquipmentDTO> equipments;
}
