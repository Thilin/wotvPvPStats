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
@Table(name = "TB_CHARACTER_BUILT")
public class CharacterBuilt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHB_ID")
    private Long id;

    @Column(name = "CHB_NAME")
    private String name;

    @OneToOne
    @JoinColumn(name = "CHB_VCD_ID", referencedColumnName = "VCD_ID")
    private VisionCard visionCard;

    @OneToOne
    @JoinColumn(name = "CHB_ESP_ID", referencedColumnName = "ESP_ID")
    private Esper esper;

    @OneToOne
    @JoinColumn(name = "CHB_CTR_ID", referencedColumnName = "CTR_ID")
    private Character character;

    @Column(name = "CHB_SECUNDARY_JOB")
    private String secundaryJob;
}
