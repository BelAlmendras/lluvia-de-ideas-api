package com.lluviadeideas.storiesapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "participacion_ilustracion")
@Getter @Setter
public class ParticipacionIlustracion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "concursoIlustracion_id", nullable = false)
    private ConcursoIlustracion concursoIlustracion;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RolConcurso rolConcurso;


    public ParticipacionIlustracion(){}
}
