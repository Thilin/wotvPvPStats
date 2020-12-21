package com.example.mxhStudio.WotVPvPStats.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "TB_EQUIPMENT_TYPE")
public class EquipmentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ETY_ID")
    private Long id;

    @Column(name = "ETY_DESCRIPTION")
    private String description;
}
