package com.example.mxhStudio.WotVPvPStats.projections.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDTO {

    private Long id;
    private String name;
    private String image;
    private String rarity;
}