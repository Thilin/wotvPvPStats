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
public class CharacterBuiltDTO {

    private Long characterId;
    private Long esperId;
    private Long visionCardId;
    private String name;
    private Long jobSecundaryId;
    private List<EquipmentBuilderDTO> equipments;
}
