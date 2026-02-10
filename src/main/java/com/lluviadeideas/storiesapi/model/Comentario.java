package com.lluviadeideas.storiesapi.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comentario")
@Getter @Setter
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Lob
    @NotBlank(message = "El comentario no puede estar en blanco")
    private String contenido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuento_id",nullable = false)
    private Cuento cuento;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    private LocalDateTime fechaCreacion;
    
    public Comentario(){};
}
