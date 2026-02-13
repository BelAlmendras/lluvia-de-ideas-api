package com.lluviadeideas.storiesapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "taller_participacion")
@Getter @Setter
public class TallerParticipacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Taller taller;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RolConcurso rolConcurso;

    public TallerParticipacion(){}
}
