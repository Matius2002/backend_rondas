package com.example.backend_rondas.Repositorios;

import com.example.backend_rondas.Entidades.Estados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadosRepository extends JpaRepository<Estados, Long> {
}
