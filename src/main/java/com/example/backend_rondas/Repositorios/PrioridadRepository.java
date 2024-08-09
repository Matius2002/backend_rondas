package com.example.backend_rondas.Repositorios;

import com.example.backend_rondas.Entidades.Prioridad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrioridadRepository extends JpaRepository<Prioridad, Long> {
}
