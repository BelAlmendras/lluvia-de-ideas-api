package com.lluviadeideas.storiesapi.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;


import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "usuarios")
@Getter @Setter
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Column(name = "nombre_usuario", unique = true, nullable = false)
    @Size(min = 3, max = 20)
    @Pattern(regexp = "^[a-zA-Z0-9_]+$")
    private String nombreUsuario;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email debe ser valido")
    @Column(unique = true, nullable = false)
    private String correo;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, max = 30, message = "La contraseña debe tener al menos 8 caracteres. Maximo 30")
    @Pattern(
    regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).+$",
    message = "La contraseña debe tener mayúscula, minúscula, número y símbolo")
    @Column(nullable = false, length = 300)
    private String password;

    @Size(max = 500)
    private String biografia;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name="roles_usuario", joinColumns = @JoinColumn(name="usuario_id"),inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Set<Rol> roles = new HashSet<>();

    @Column(nullable = false)
    private boolean activo = true;

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


    public Usuario() {}


}
