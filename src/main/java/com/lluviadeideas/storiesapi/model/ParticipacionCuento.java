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
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "participacion_cuento",uniqueConstraints = @UniqueConstraint(columnNames={"concurso_cuento_id", "cuento_id" }))
@Getter @Setter
public class ParticipacionCuento{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "concurso_cuento_id",nullable = false)
    private ConcursoCuento concursoCuento;

@ManyToOne
@JoinColumn(name = "cuento_id", nullable = false)
private Cuento cuento;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RolConcurso rolConcurso;


    public ParticipacionCuento(){}
}
