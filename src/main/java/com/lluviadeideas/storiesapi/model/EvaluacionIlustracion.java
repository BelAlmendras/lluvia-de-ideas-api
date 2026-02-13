package com.lluviadeideas.storiesapi.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "evaluacion_cuento,  uniqueConstraints = {\n" + //
        "      @UniqueConstraint(columnNames = {\"juez_id\", \"cuento_id\", \"concurso_cuento_id\"})\n" + //
        "   }")
@Getter @Setter
public class EvaluacionIlustracion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable=false)
    private Usuario juez;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Ilustracion Ilustracion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private ConcursoIlustracion concursoIlustracion;
    
    @NotNull(message = "El puntaje es obligatorio")
    private Integer puntaje;

    @Lob
    @NotBlank(message = "El comentario es obigatorio")
    private String comentario;

    @Column(nullable = false)
    private boolean revisadoAdmin = false;

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

public EvaluacionIlustracion(){}

}
