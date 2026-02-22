package com.lluviadeideas.storiesapi.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "concurso_ilustracion")
@Getter @Setter
public class ConcursoIlustracion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del concurso es obligatorio")
    private String nombre;

    @Lob
    @NotBlank(message = "La descripcion es obligatoria")
    private String descripcion;

    @OneToMany(mappedBy = "concursoIlustracion")
    private List<Ilustracion> ilustraciones = new ArrayList<>();//es necesario?
 
    @OneToMany(mappedBy = "participacionIlustracion")
    private List<ParticipacionIlustracion> participaciones = new ArrayList<>();

    @NotBlank
    private String bases;

    @Column(nullable=false)
    private LocalDate fechaInicio;

    @Column(nullable=false)
    private LocalDate fechaFinal;

    @Column(nullable=false)
    private boolean activo=true;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
      createdAt = LocalDateTime.now();
      updatedAt = LocalDateTime.now();
}

    @PreUpdate
    protected void onUpdate() {
    updatedAt = LocalDateTime.now();
}
 
public ConcursoIlustracion(){}
}
