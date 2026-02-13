package com.lluviadeideas.storiesapi.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="taller")
@Getter @Setter
public class Taller {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del concurso es obligatorio")
    @Column(nullable = false, length = 100)
    private String nombre;

    @Lob
    @NotBlank(message = "La descripcion es obligatoria")
    private String descripcion;

    @JoinColumn
    private List<Usuario> tallerista= new ArrayList<>();

    @JoinColumn
    private List<Usuario> participantes= new ArrayList<>();

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
    
     public Taller(){}


}
