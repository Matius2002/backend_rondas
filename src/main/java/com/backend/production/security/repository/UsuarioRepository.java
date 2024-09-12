package com.backend.production.security.repository;

import com.backend.production.security.models.Rol;
import com.backend.production.security.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findFirstByEmail(String email);
    Usuario findByRol(Rol userRole);
    Optional<Usuario> findByEmail(String email);
}