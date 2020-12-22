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
@Table(name = "TB_CHARACTER_BUILT_EQUIPMENT")
public class CharacterBuiltEquipments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHE_ID")
    private Long id;

    @Column(name = "CHE_PLUS")
    private Integer plus;


    @ManyToOne
    @JoinColumn(name = "CHE_EQP_ID", referencedColumnName = "EQP_ID")
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "CHE_CHB_ID", referencedColumnName = "CHB_ID")
    private CharacterBuilt characterBuilt;
}
