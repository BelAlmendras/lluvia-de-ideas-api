package com.lluviadeideas.storiesapi.model;

import java.time.LocalDateTime;
import java.util.*;
import jakarta.persistence.CascadeType;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cuentos")
@Getter @Setter
public class Cuento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El cuento debe tener un titulo")
    @Column(nullable = false,  length =100)
    private String titulo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id",nullable = false)
    private Usuario usuario;


    @NotBlank(message = "El cuento debe tener contenido")
    @Lob
    @Column(nullable = false)
    private String contenido;

    @ManyToMany
    @JoinTable(name = "cuento_categoria", joinColumns = @JoinColumn(name="cuento_id"),
    inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private Set<Categoria> categorias = new HashSet<>();

    @OneToMany(mappedBy = "cuento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ilustracion> ilustraciones = new ArrayList<>();


    @Enumerated(EnumType.STRING)
    @NotNull
    private EstadoCuento estadoCuento = EstadoCuento.BORRADOR;

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

@NotNull(message = "Debes aceptar la declaración legal")
@Column(nullable = false)
private Boolean declaraLegal;

private LocalDateTime fechaDeclaracion;

@OneToMany(mappedBy = "cuento")
 private List<Comentario> comentarios;

@OneToMany(mappedBy = "cuento")
private List<Reporte> reportes = new ArrayList<>();

@ManyToOne
@JoinColumn(name = "concurso_id", nullable = true)
private ConcursoCuento concurso;


public Cuento() {}

}
