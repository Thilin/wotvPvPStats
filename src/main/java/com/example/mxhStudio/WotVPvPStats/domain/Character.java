package com.example.mxhStudio.WotVPvPStats.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_CHARACTER")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CTR_ID")
    private Long id;

    @Column(name = "CTR_NAME")
    private String name;

    @Column(name = "CTR_IMAGE")
    private String image;

    @Column(name = "CTR_RARITY")
    private String rarity;
}
