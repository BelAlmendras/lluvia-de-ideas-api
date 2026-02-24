package com.lluviadeideas.storiesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lluviadeideas.storiesapi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    
    
}
