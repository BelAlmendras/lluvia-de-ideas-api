package com.lluviadeideas.storiesapi.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "conversacion", uniqueConstraints = @UniqueConstraint(columnNames = {"usuario1","usuario2"}))
@Getter @Setter
public class Conversacion {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario1;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario2;


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
}
