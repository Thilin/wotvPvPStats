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
public class JobsCharacterDTO {

    private String name;
    private List<JobsDTO> jobs;
}
