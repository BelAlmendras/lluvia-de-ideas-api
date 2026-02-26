package com.lluviadeideas.storiesapi.model;
import java.time.LocalDateTime;

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
@Table(name = "rol_cuento")
@Getter @Setter
public class RolCuento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @ManyToOne
   private Usuario usuario;

   @ManyToOne
   private ConcursoCuento concursoCuento;

   @Enumerated(EnumType.STRING)
   private RolConcurso rol;

   private LocalDateTime fechaAsignacion;

   private boolean activo;
}
