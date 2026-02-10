package com.lluviadeideas.storiesapi.model;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reporte")
@Getter @Setter
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Debe tener un asunto")
    @Column(nullable = false, length = 100)
    private String asunto;

    @NotBlank(message = "Debe tener un contenido")
    @Column(nullable = false, length = 1000)
    private String contenido;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuento_id", nullable = false)
    private Cuento cuento;

     @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    public Reporte(){
        this.fechaCreacion = LocalDateTime.now();
    }
}
