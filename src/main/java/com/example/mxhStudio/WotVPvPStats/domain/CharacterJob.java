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
@Table(name = "TB_CHARACTER_JOB")
public class CharacterJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CJO_ID")
    private Long id;

    @Column(name = "CJO_ISMAIN")
    private boolean isMain;

    @ManyToOne
    @JoinColumn(name = "CJO_JOB_ID", referencedColumnName = "JOB_ID")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "CJO_CTR_ID", referencedColumnName = "CTR_ID")
    private Character character;
}
