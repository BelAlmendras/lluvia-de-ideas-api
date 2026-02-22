package com.lluviadeideas.storiesapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categorias")
@Getter @Setter
public class Categoria {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotBlank(message = "El nombre de la categoria no debe estar vacio")
@Column(nullable = false, unique = true)
private String nombre;

public Categoria() {}

}
