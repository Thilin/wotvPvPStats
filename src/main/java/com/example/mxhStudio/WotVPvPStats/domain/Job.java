package com.example.mxhStudio.WotVPvPStats.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "TB_JOB")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JOB_ID")
    private Long id;

    @Column(name = "JOB_DESCRIPTION")
    private String description;

    @Column(name = "JOB_IMAGE")
    private String image;
}
