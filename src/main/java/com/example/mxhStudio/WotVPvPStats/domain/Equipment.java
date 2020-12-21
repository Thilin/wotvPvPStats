package com.example.mxhStudio.WotVPvPStats.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_EQUIPMENT")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EQP_ID")
    private Long id;

    @Column(name = "EQP_NAME")
    private String name;

    @Column(name = "EQP_IMAGE")
    private String image;

    @OneToOne
    @JoinColumn(name = "EQP_ETY_ID", referencedColumnName = "ETY_ID")
    private EquipmentType equipmentType;

}
